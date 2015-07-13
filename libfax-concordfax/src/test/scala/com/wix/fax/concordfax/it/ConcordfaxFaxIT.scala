package com.wix.fax.concordfax.it

import com.google.api.client.http.javanet.NetHttpTransport
import com.twitter.util.{Throw, Try}
import com.wix.fax.FaxErrorException
import com.wix.fax.concordfax.model.Statuses
import com.wix.fax.concordfax.testkit.{ConcordfaxDriver, SendFaxResponse}
import com.wix.fax.concordfax.{ConcordfaxFax, Credentials}
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.testkit.FaxDocumentBuilder
import org.specs2.matcher._
import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope

import scala.reflect.ClassTag


class ConcordfaxFaxIT extends SpecWithJUnit {
  private val concordfaxPort = 10008

  val driver = new ConcordfaxDriver(port = concordfaxPort)
  step {
    driver.startProbe()
  }

  sequential

  trait Ctx extends Scope with FaxDocumentBuilder {
    val requestFactory = new NetHttpTransport().createRequestFactory()

    val someFaxDocumentHtml = buildHtmlFaxDocument()

    val someCredentials = Credentials(
      username = "some username",
      password = "some password"
    )
    val someTo = "+390669882417"

    val someJobId = "some job ID"

    def aSuccessfulSendFaxResponse: SendFaxResponse = {
      SendFaxResponse(
        `return` = true,
        jobId = someJobId,
        errorCode = 0,
        errorString = "some successful error string"
      )
    }

    def aFailedSendFaxResponse: SendFaxResponse = {
      SendFaxResponse(
        `return` = false,
        jobId = someJobId,
        errorCode = -666,
        errorString = "some error string"
      )
    }

    val fax: Fax = new ConcordfaxFax(
      endpoint = s"http://localhost:$concordfaxPort/",
      credentials = someCredentials
    )

    driver.resetProbe()
  }

  def beSuccessful(string: Matcher[String] = AlwaysMatcher()): Matcher[Try[String]] = {
    TwitterTrySuccessMatcher[String]() and
      string ^^ { (_: Try[String]).get()}
  }

  def beFailure[T <: Throwable : ClassTag](msg: Matcher[String] = AlwaysMatcher(),
                                           cause: Matcher[Throwable] = AlwaysMatcher()): Matcher[Try[String]] = {
    TwitterTryFailureMatcher[String]() and
      beAnInstanceOf[T] ^^ { (_: Try[String]) match {
        case Throw(e) => e
        case _ => failure("Expected a failure (exception), but was successful")
      }} and
      new Matcher[Try[String]] {
        override def apply[S <: Try[String]](expectable: Expectable[S]): MatchResult[S] = {
          expectable.value match {
            case Throw(e) => createExpectable(e.getMessage).applyMatcher(msg).asInstanceOf[MatchResult[S]]
            case _ => failure("Expected a failure (exception), but was successful", expectable)
          }
        }
      } and
      new Matcher[Try[String]] {
        override def apply[S <: Try[String]](expectable: Expectable[S]): MatchResult[S] = {
          expectable.value match {
            case Throw(e) => createExpectable(e.getCause).applyMatcher(cause).asInstanceOf[MatchResult[S]]
            case _ => failure("Expected a failure (exception), but was successful", expectable)
          }
        }
      }
  }


  "send request via Concord Fax" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendFaxFor(someCredentials, someTo, someFaxDocumentHtml) returns aSuccessfulSendFaxResponse

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml
      ) must beSuccessful(
        string = ===(someJobId)
      )
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendFaxFor(someCredentials, someTo, someFaxDocumentHtml) returns aFailedSendFaxResponse

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml
      ) must beFailure[FaxErrorException](
        msg = ===(s"${aFailedSendFaxResponse.errorCode}|${aFailedSendFaxResponse.errorString}")
      )
    }
  }

  "retrieveStatus request via Concord Fax" should {
    "successfully yield a 'pending' status on valid request" in new Ctx {
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns Statuses.processed

      fax.retrieveStatus(
        documentId = someJobId
      ) must beSuccessful(
        string = ===(Status.pending)
      )
    }

    "successfully yield a 'sent' status on valid request" in new Ctx {
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns Statuses.succeeded

      fax.retrieveStatus(
        documentId = someJobId
      ) must beSuccessful(
        string = ===(Status.sent)
      )
    }

    "successfully yield a 'failed' status on valid request" in new Ctx {
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns Statuses.failed

      fax.retrieveStatus(
        documentId = someJobId
      ) must beSuccessful(
        string = ===(Status.failed)
      )
    }

    "gracefully fail on error" in new Ctx {
      val unknownStatus = -666
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns unknownStatus

      fax.retrieveStatus(
        documentId = someJobId
      ) must beFailure[FaxErrorException](
        msg = contain(unknownStatus.toString)
      )
    }
  }

  step {
    driver.stopProbe()
  }
}

case class TwitterTrySuccessMatcher[T]() extends OptionLikeMatcher[Try, T, T]("a Success", (_: Try[T]).toOption)
case class TwitterTryFailureMatcher[T]() extends OptionLikeMatcher[Try, T, Throwable](
  "a Failure",
  (_: Try[T]) match {
    case Throw(e) => Option(e)
    case _ => None
  })
