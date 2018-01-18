package com.wix.fax.phaxio.it


import scala.concurrent.duration._
import org.specs2.matcher.Matcher
import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope
import com.google.api.client.http.HttpRequestFactory
import com.google.api.client.http.javanet.NetHttpTransport
import com.wix.fax.FaxErrorException
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.phaxio.model.{FaxStatusResponse, SendResponse, Fax => PhaxioFaxDocument, Status => PhaxioStatus, _}
import com.wix.fax.phaxio.testkit.PhaxioDriver
import com.wix.fax.phaxio.{Credentials, PhaxioFax, PhaxioHelper}
import com.wix.fax.testkit.FaxDocumentBuilder._


class PhaxioFaxIT extends SpecWithJUnit {
  private val phaxioPort = 10007
  val someFaxId = 1234L
  val someFaxId2 = 5678L
  val someErrorMessage = "some error message"
  val someTo = "+390669882417"
  val someCancelTimeout: FiniteDuration = 3.minutes
  val someFaxDocumentHtml: String = buildHtmlFaxDocument()
  val someCredentials = Credentials(
    key = "some key",
    secret = "some secret")

  val driver = new PhaxioDriver(port = phaxioPort)
  val requestFactory: HttpRequestFactory = new NetHttpTransport().createRequestFactory()

  val fax: Fax = new PhaxioFax(
    requestFactory = requestFactory,
    endpoint = s"http://localhost:$phaxioPort/",
    connectTimeout = Some(5.seconds),
    readTimeout = Some(5.seconds),
    credentials = someCredentials,
    cancelTimeout = someCancelTimeout)


  def aSendRequest(): Map[String, String] = {
    PhaxioHelper.createSendParams(
      credentials = someCredentials,
      to = someTo,
      html = someFaxDocumentHtml,
      cancelTimeout = someCancelTimeout)
  }

  def aFaxStatusRequest(faxId: Long): Map[String, String] = {
    PhaxioHelper.createFaxStatusParams(
      credentials = someCredentials,
      id = faxId)
  }

  def aSuccessfulSendResponse(): SendResponse = {
    SendResponse(
      success = true,
      message = null,
      faxId = Some(someFaxId),
      data = Some(FaxInfo(
        faxId = someFaxId)))
  }

  def aFailedSendResponse(): SendResponse = {
    SendResponse(
      success = false,
      message = someErrorMessage)
  }

  private def aFaxStatusResponse(faxId: Long, status: String): FaxStatusResponse = {
    FaxStatusResponse(
      success = true,
      message = "some success message",
      data = Some(PhaxioFaxDocument(
        id = faxId,
        direction = Direction.sent,
        num_pages = 1,
        cost = 1,
        status = status,
        is_test = false,
        requested_at = System.currentTimeMillis(),
        recipients = List(Recipient(
          number = someTo,
          status = status)))))
  }

  def aPendingFaxStatusResponse(faxId: Long): FaxStatusResponse = aFaxStatusResponse(faxId, PhaxioStatus.inProgress)

  def aSentFaxStatusResponse(faxId: Long): FaxStatusResponse = aFaxStatusResponse(faxId, PhaxioStatus.success)

  def aSendFailedFaxStatusResponse(faxId: Long): FaxStatusResponse = aFaxStatusResponse(faxId, PhaxioStatus.failure)

  def aFailedFaxStatusResponse(): FaxStatusResponse = {
    FaxStatusResponse(
      success = false,
      message = someErrorMessage)
  }

  def beAnExceptionWithErrorMessage[T <: Throwable](errorMessage: String): Matcher[Throwable] = {
    (contain(errorMessage) ^^ { (_: T).getMessage }).asInstanceOf[Matcher[Throwable]]
  }


  step {
    driver.start()
  }


  sequential


  trait Ctx extends Scope {
    driver.reset()
  }


  "send request via Phaxio" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendFor(aSendRequest()) returns aSuccessfulSendResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beASuccessfulTry(check = ===(someFaxId.toString))
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendFor(aSendRequest()) returns aFailedSendResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beAFailedTry(
          check = beAnExceptionWithErrorMessage[FaxErrorException](someErrorMessage))
    }
  }


  "retrieveStatus request via Phaxio" should {
    "successfully yield a 'pending' status on valid request" in new Ctx {
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId)) returns aPendingFaxStatusResponse(someFaxId)

      fax.retrieveStatus(documentId = someFaxId.toString) must beASuccessfulTry(check = ===(Status.pending))
    }

    "successfully yield a 'sent' status on valid request" in new Ctx {
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId)) returns aSentFaxStatusResponse(someFaxId)

      fax.retrieveStatus(documentId = someFaxId.toString) must beASuccessfulTry(check = ===(Status.sent))
    }

    "successfully yield a 'failed' status on valid request" in new Ctx {
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId)) returns aSendFailedFaxStatusResponse(someFaxId)

      fax.retrieveStatus(documentId = someFaxId.toString) must beASuccessfulTry(check = ===(Status.failed))
    }

    "gracefully fail on error" in new Ctx {
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId)) returns aFailedFaxStatusResponse()

      fax.retrieveStatus(documentId = someFaxId.toString) must beAFailedTry(
        check = beAnExceptionWithErrorMessage[FaxErrorException](someErrorMessage))
    }
  }


  "retrieveStatuses request via Phaxio" should {
    "successfully yield statuses on valid requests" in new Ctx {
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId)) returns aPendingFaxStatusResponse(someFaxId)
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId2)) returns aSentFaxStatusResponse(someFaxId2)

      fax.retrieveStatuses(documentIds = List(someFaxId.toString, someFaxId2.toString)) must beASuccessfulTry(
        check = ===(Map(
          someFaxId.toString -> Status.pending,
          someFaxId2.toString -> Status.sent)))
    }

    "gracefully fail on error" in new Ctx {
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId)) returns aPendingFaxStatusResponse(someFaxId)
      driver.aFaxStatusFor(aFaxStatusRequest(someFaxId2)) returns aFailedFaxStatusResponse()

      fax.retrieveStatuses(documentIds = List(someFaxId.toString, someFaxId2.toString)) must beAFailedTry(
        check = beAnExceptionWithErrorMessage[FaxErrorException](someErrorMessage))
    }
  }


  step {
    driver.stop()
  }
}
