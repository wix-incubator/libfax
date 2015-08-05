package com.wix.fax.phaxio.it

import com.google.api.client.http.javanet.NetHttpTransport
import com.wix.fax.FaxErrorException
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.phaxio.model.{Fax => PhaxioFaxDocument, FaxStatusResponse, SendResponse, Status => PhaxioStatus, _}
import com.wix.fax.phaxio.testkit.PhaxioDriver
import com.wix.fax.phaxio.{Credentials, PhaxioFax, PhaxioHelper}
import com.wix.fax.testkit.FaxDocumentBuilder
import com.wix.fax.testkit.TwitterTryMatchers._
import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope

import scala.concurrent.duration._


class PhaxioFaxIT extends SpecWithJUnit {
  private val phaxioPort = 10007

  val driver = new PhaxioDriver(port = phaxioPort)
  step {
    driver.startProbe()
  }

  sequential

  trait Ctx extends Scope with FaxDocumentBuilder {
    val requestFactory = new NetHttpTransport().createRequestFactory()

    val someFaxDocumentHtml = buildHtmlFaxDocument()

    val someCredentials = Credentials(
      key = "some key",
      secret = "some secret"
    )
    val someTo = "+390669882417"

    val someCancelTimeout = 3.minutes

    val fax: Fax = new PhaxioFax(
      requestFactory = requestFactory,
      endpoint = s"http://localhost:$phaxioPort/",
      connectTimeout = Some(5.seconds),
      readTimeout = Some(5.seconds),
      credentials = someCredentials,
      cancelTimeout = someCancelTimeout
    )

    def aSendRequest(): Map[String, String] = {
      val helper = new PhaxioHelper
      helper.createSendParams(
        credentials = someCredentials,
        to = someTo,
        html = someFaxDocumentHtml,
        cancelTimeout = someCancelTimeout
      )
    }

    def aFaxStatusRequest(): Map[String, String] = {
      val helper = new PhaxioHelper
      helper.createFaxStatusParams(
        credentials = someCredentials,
        id = someFaxId
      )
    }

    val someFaxId = 1234L
    def aSuccessfulSendResponse(): SendResponse = {
      SendResponse(
        success = true,
        message = null,
        faxId = Some(someFaxId),
        data = Some(FaxInfo(
          faxId = someFaxId
        ))
      )
    }

    val someErrorMessage = "some error message"
    def aFailedSendResponse(): SendResponse = {
      SendResponse(
        success = false,
        message = someErrorMessage
      )
    }

    private def aFaxStatusResponse(status: String): FaxStatusResponse = {
      FaxStatusResponse(
        success = true,
        message = "some success message",
        data = Some(PhaxioFaxDocument(
          id = someFaxId,
          direction = Direction.sent,
          num_pages = 1,
          cost = 1,
          status = status,
          is_test = false,
          requested_at = System.currentTimeMillis(),
          recipients = List(Recipient(
            number = someTo,
            status = status
          ))
        ))
      )
    }

    def aPendingFaxStatusResponse(): FaxStatusResponse = {
      aFaxStatusResponse(PhaxioStatus.inProgress)
    }

    def aSentFaxStatusResponse(): FaxStatusResponse = {
      aFaxStatusResponse(PhaxioStatus.success)
    }

    def aSendFailedFaxStatusResponse(): FaxStatusResponse = {
      aFaxStatusResponse(PhaxioStatus.failure)
    }

    def aFailedFaxStatusResponse(): FaxStatusResponse = {
      FaxStatusResponse(
        success = false,
        message = someErrorMessage
      )
    }

    driver.resetProbe()
  }

  "send request via Phaxio" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendFor(
        aSendRequest()
      ) returns aSuccessfulSendResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beSuccessful(value = ===(someFaxId.toString))
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendFor(
        aSendRequest()
      ) returns aFailedSendResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beFailure[String, FaxErrorException](msg = ===(someErrorMessage))
    }
  }

  "retrieveStatus request via Phaxio" should {
    "successfully yield a 'pending' status on valid request" in new Ctx {
      driver.aFaxStatusFor(
        aFaxStatusRequest()
      ) returns aPendingFaxStatusResponse()

      fax.retrieveStatus(
        documentId = someFaxId.toString
      ) must beSuccessful(value = ===(Status.pending))
    }

    "successfully yield a 'sent' status on valid request" in new Ctx {
      driver.aFaxStatusFor(
        aFaxStatusRequest()
      ) returns aSentFaxStatusResponse()

      fax.retrieveStatus(
        documentId = someFaxId.toString
      ) must beSuccessful(value = ===(Status.sent))
    }

    "successfully yield a 'failed' status on valid request" in new Ctx {
      driver.aFaxStatusFor(
        aFaxStatusRequest()
      ) returns aSendFailedFaxStatusResponse()

      fax.retrieveStatus(
        documentId = someFaxId.toString
      ) must beSuccessful(value = ===(Status.failed))
    }

    "gracefully fail on error" in new Ctx {
      driver.aFaxStatusFor(
        aFaxStatusRequest()
      ) returns aFailedFaxStatusResponse()

      fax.retrieveStatus(
        documentId = someFaxId.toString
      ) must beFailure[String, FaxErrorException](msg = ===(someErrorMessage))
    }
  }

  step {
    driver.stopProbe()
  }
}
