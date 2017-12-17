package com.wix.fax.interfax.sl.it


import scala.collection.JavaConverters._
import scala.concurrent.duration._
import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope
import com.google.api.client.http.HttpRequestFactory
import com.google.api.client.http.javanet.NetHttpTransport
import com.wix.fax.FaxErrorException
import com.wix.fax.interfax.sl.model._
import com.wix.fax.interfax.sl.testkit.InterfaxslDriver
import com.wix.fax.interfax.sl.{Credentials, InterfaxslFax, InterfaxslHelper}
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.testkit.FaxDocumentBuilder._


class InterfaxslFaxIT extends SpecWithJUnit {
  private val interfaxslPort = 10006

  val driver = new InterfaxslDriver(port = interfaxslPort)
  val requestFactory: HttpRequestFactory = new NetHttpTransport().createRequestFactory()

  val someTransactionId = 1234L
  val someTransactionId2 = 5678L
  val someTo = "+390669882417"
  val someErrorCode: Int = ErrorCode.invalidRecipient
  val someFaxDocumentHtml: String = buildHtmlFaxDocument()
  val someCredentials = Credentials(
    username = "some username",
    password = "some password")

  val fax: Fax = new InterfaxslFax(
    requestFactory = requestFactory,
    endpoint = s"http://localhost:$interfaxslPort/",
    connectTimeout = Some(5.seconds),
    readTimeout = Some(5.seconds),
    credentials = someCredentials)


  def aSendCharFaxRequest(): Map[String, String] = {
    InterfaxslHelper.createSendCharFaxParams(
      credentials = someCredentials,
      to = someTo,
      html = someFaxDocumentHtml)
  }


  def aQueryListRequest(): Map[String, String] = {
    InterfaxslHelper.createQueryListParams(
      credentials = someCredentials,
      transactionIds = List(someTransactionId))
  }

  def aQueryListRequestWithMultipleIds(): Map[String, String] = {
    InterfaxslHelper.createQueryListParams(
      credentials = someCredentials,
      transactionIds = List(someTransactionId, someTransactionId2))
  }

  def aSuccessfulSendCharFaxResponse(): SendCharFaxResponse = {
    val sendCharFaxResponse = new SendCharFaxResponse
    sendCharFaxResponse.value = someTransactionId
    sendCharFaxResponse
  }

  def aFailedSendCharFaxResponse(): SendCharFaxResponse = {
    val sendCharFaxResponse = new SendCharFaxResponse
    sendCharFaxResponse.value = someErrorCode.toLong
    sendCharFaxResponse
  }

  private def aQueryResult(statusCode: Int): QueryResult = {
    aQueryResultWithMultipleIds(Map(someTransactionId -> statusCode))
  }

  def aQueryResultWithMultipleIds(statusCodes: Map[Long, Int]): QueryResult = {
    val faxItems = statusCodes.map {
      case (transactionId, statusCode) =>
        val faxItem = new FaxItemEx
        faxItem.TransactionID = transactionId
        faxItem.Status = statusCode
        faxItem
    }

    val queryResult = new QueryResult
    queryResult.ResultCode = ErrorCode.ok
    queryResult.FaxItems = new FaxItems
    queryResult.FaxItems.FaxItem = faxItems.toList.asJava

    queryResult
  }

  def aPendingQueryResult(): QueryResult = aQueryResult(StatusCode.ready)

  def aSentQueryResult(): QueryResult = aQueryResult(StatusCode.ok)

  def aSendFailedQueryResult(): QueryResult = aQueryResult(StatusCode.busy)

  def aFailedQueryResult(): QueryResult = {
    val queryResult = new QueryResult
    queryResult.ResultCode = someErrorCode
    queryResult
  }


  step {
    driver.start()
  }


  sequential


  trait Ctx extends Scope {
    driver.reset()
  }


  "send request via InterFax SecureLounge" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendCharFaxFor(aSendCharFaxRequest()) returns aSuccessfulSendCharFaxResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beASuccessfulTry(check = ===(someTransactionId.toString))
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendCharFaxFor(aSendCharFaxRequest()) returns aFailedSendCharFaxResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beAFailedTry(check = FaxErrorException(someErrorCode.toString))
    }
  }

  "retrieveStatus request via InterFax SecureLounge" should {
    "successfully yield a 'pending' status on valid request" in new Ctx {
      driver.aQueryListFor(aQueryListRequest()) returns aPendingQueryResult()

      fax.retrieveStatus(documentId = someTransactionId.toString) must beASuccessfulTry(check = ===(Status.pending))
    }

    "successfully yield a 'sent' status on valid request" in new Ctx {
      driver.aQueryListFor(aQueryListRequest()) returns aSentQueryResult()

      fax.retrieveStatus(documentId = someTransactionId.toString) must beASuccessfulTry(check = ===(Status.sent))
    }

    "successfully yield a 'failed' status on valid request" in new Ctx {
      driver.aQueryListFor(aQueryListRequest()) returns aSendFailedQueryResult()

      fax.retrieveStatus(documentId = someTransactionId.toString) must beASuccessfulTry(check = ===(Status.failed))
    }

    "gracefully fail on error" in new Ctx {
      driver.aQueryListFor(aQueryListRequest()) returns aFailedQueryResult()

      fax.retrieveStatus(documentId = someTransactionId.toString) must beAFailedTry(
        check = FaxErrorException(someErrorCode.toString))
    }
  }


  "retrieveStatuses request via InterFax SecureLounge" should {
    "successfully yield statuses on valid request" in new Ctx {
      driver.aQueryListFor(aQueryListRequestWithMultipleIds()) returns aQueryResultWithMultipleIds(Map(
        someTransactionId -> StatusCode.ready,
        someTransactionId2 -> StatusCode.ok))

      fax.retrieveStatuses(documentIds = List(someTransactionId.toString, someTransactionId2.toString)) must
        beASuccessfulTry(check = ===(Map(
          someTransactionId.toString -> Status.pending,
          someTransactionId2.toString -> Status.sent)))
    }

    "gracefully fail on error" in new Ctx {
      driver.aQueryListFor(aQueryListRequestWithMultipleIds()) returns aFailedQueryResult()

      fax.retrieveStatuses(documentIds = List(someTransactionId.toString, someTransactionId2.toString)) must
        beAFailedTry(check = FaxErrorException(someErrorCode.toString))
    }
  }


  step {
    driver.stop()
  }
}
