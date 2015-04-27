package com.wix.restaurants.fax.interfax.sl.it

import com.google.api.client.http.javanet.NetHttpTransport
import com.twitter.util.{Throw, Try}
import com.wix.restaurants.fax.FaxErrorException
import com.wix.restaurants.fax.interfax.sl.model.ErrorCode
import com.wix.restaurants.fax.interfax.sl.testkit.InterfaxslDriver
import com.wix.restaurants.fax.interfax.sl.{Credentials, InterfaxslFax, InterfaxslHelper}
import com.wix.restaurants.fax.model.Fax
import com.wix.restaurants.fax.testkit.FaxDocumentBuilder
import org.specs2.matcher._
import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope
import org.specs2.time.NoTimeConversions

import scala.concurrent.duration._
import scala.reflect.ClassTag


class InterfaxslFaxIT extends SpecificationWithJUnit with NoTimeConversions {
  private val interfaxslPort = 10006

  val driver = new InterfaxslDriver(port = interfaxslPort)
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

    val fax: Fax = new InterfaxslFax(
      requestFactory = requestFactory,
      endpoint = s"http://localhost:$interfaxslPort/",
      connectTimeout = Some(5.seconds),
      readTimeout = Some(5.seconds),
      credentials = someCredentials
    )

    def aSendCharFaxRequest(): Map[String, String] = {
      val helper = new InterfaxslHelper
      helper.createSendCharFaxParams(
        credentials = someCredentials,
        to = someTo,
        html = someFaxDocumentHtml
      )
    }

    val someTransactionId = 1234L

    val someErrorCode = ErrorCode.invalidRecipient

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

  "send request via InterFax SecureLounge" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendCharFaxFor(
        aSendCharFaxRequest()
      ) returns someTransactionId

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beSuccessful(string = ===(someTransactionId.toString))
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendCharFaxFor(
        aSendCharFaxRequest()
      ) returns someErrorCode

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beFailure[FaxErrorException](msg = contain(someErrorCode.toString))
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
