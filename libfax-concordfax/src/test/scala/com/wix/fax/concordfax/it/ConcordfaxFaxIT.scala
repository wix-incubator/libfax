package com.wix.fax.concordfax.it


import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope
import com.google.api.client.http.HttpRequestFactory
import com.google.api.client.http.javanet.NetHttpTransport
import com.wix.fax.FaxErrorException
import com.wix.fax.concordfax.model.Statuses
import com.wix.fax.concordfax.testkit.{ConcordfaxDriver, SendFaxResponse}
import com.wix.fax.concordfax.{ConcordfaxFax, Credentials}
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.testkit.FaxDocumentBuilder._


class ConcordfaxFaxIT extends SpecWithJUnit {
  private val concordfaxPort = 10008
  val someTo = "+390669882417"
  val someJobId = "some job ID"
  val someFaxDocumentHtml: String = buildHtmlFaxDocument()
  val someCredentials = Credentials(
    username = "some username",
    password = "some password")

  val driver = new ConcordfaxDriver(port = concordfaxPort)
  val requestFactory: HttpRequestFactory = new NetHttpTransport().createRequestFactory()

  val fax: Fax = new ConcordfaxFax(
    endpoint = s"http://localhost:$concordfaxPort/",
    credentials = someCredentials)


  def aSuccessfulSendFaxResponse: SendFaxResponse = {
    SendFaxResponse(
      `return` = true,
      jobId = someJobId,
      errorCode = 0,
      errorString = "some successful error string")
  }

  def aFailedSendFaxResponse: SendFaxResponse = {
    SendFaxResponse(
      `return` = false,
      jobId = someJobId,
      errorCode = -666,
      errorString = "some error string")
  }


  step {
    driver.start()
  }


  sequential


  trait Ctx extends Scope {
    driver.reset()
  }


  "send request via Concord Fax" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendFaxFor(someCredentials, someTo, someFaxDocumentHtml) returns aSuccessfulSendFaxResponse

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beASuccessfulTry(check = ===(someJobId))
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendFaxFor(someCredentials, someTo, someFaxDocumentHtml) returns aFailedSendFaxResponse

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beAFailedTry(
          check = FaxErrorException(s"${aFailedSendFaxResponse.errorCode}|${aFailedSendFaxResponse.errorString}"))
    }
  }


  "retrieveStatus request via Concord Fax" should {
    "successfully yield a 'pending' status on valid request" in new Ctx {
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns Statuses.processed

      fax.retrieveStatus(documentId = someJobId) must beASuccessfulTry(check = ===(Status.pending))
    }

    "successfully yield a 'sent' status on valid request" in new Ctx {
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns Statuses.succeeded

      fax.retrieveStatus(documentId = someJobId) must beASuccessfulTry(check = ===(Status.sent))
    }

    "successfully yield a 'failed' status on valid request" in new Ctx {
      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns Statuses.failed

      fax.retrieveStatus(documentId = someJobId) must beASuccessfulTry(check = ===(Status.failed))
    }

    "gracefully fail on error" in new Ctx {
      val unknownStatus: Int = -666

      driver.aSimpleGetFaxStatusFor(someCredentials, someJobId) returns unknownStatus

      fax.retrieveStatus(documentId = someJobId) must beAFailedTry(check = FaxErrorException(unknownStatus.toString))
    }
  }


  step {
    driver.stop()
  }
}
