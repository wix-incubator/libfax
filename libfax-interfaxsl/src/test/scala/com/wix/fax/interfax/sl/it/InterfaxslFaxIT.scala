package com.wix.fax.interfax.sl.it

import java.util

import com.google.api.client.http.javanet.NetHttpTransport
import com.wix.fax.FaxErrorException
import com.wix.fax.interfax.sl.model._
import com.wix.fax.interfax.sl.testkit.InterfaxslDriver
import com.wix.fax.interfax.sl.{Credentials, InterfaxslFax, InterfaxslHelper}
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.testkit.FaxDocumentBuilder
import com.wix.fax.testkit.TwitterTryMatchers._
import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope

import scala.concurrent.duration._


class InterfaxslFaxIT extends SpecWithJUnit {
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

    def aQueryListRequest(): Map[String, String] = {
      val helper = new InterfaxslHelper
      helper.createQueryListParams(
        credentials = someCredentials,
        transactionIds = List(someTransactionId)
      )
    }

    val someTransactionId = 1234L
    def aSuccessfulSendCharFaxResponse(): SendCharFaxResponse = {
      val sendCharFaxResponse = new SendCharFaxResponse
      sendCharFaxResponse.value = someTransactionId
      sendCharFaxResponse
    }

    val someErrorCode = ErrorCode.invalidRecipient
    def aFailedSendCharFaxResponse(): SendCharFaxResponse = {
      val sendCharFaxResponse = new SendCharFaxResponse
      sendCharFaxResponse.value = someErrorCode.toLong
      sendCharFaxResponse
    }

    private def aQueryResult(statusCode: Int): QueryResult = {
      val faxItem = new FaxItemEx
      faxItem.TransactionID = someTransactionId
      faxItem.Status = statusCode

      val queryResult = new QueryResult
      queryResult.ResultCode = ErrorCode.ok
      queryResult.FaxItems = new FaxItems
      queryResult.FaxItems.FaxItem = new util.LinkedList
      queryResult.FaxItems.FaxItem.add(faxItem)

      queryResult
    }

    def aPendingQueryResult(): QueryResult = {
      aQueryResult(StatusCode.ready)
    }

    def aSentQueryResult(): QueryResult = {
      aQueryResult(StatusCode.ok)
    }

    def aSendFailedQueryResult(): QueryResult = {
      aQueryResult(StatusCode.busy)
    }

    def aFailedQueryResult(): QueryResult = {
      val queryResult = new QueryResult
      queryResult.ResultCode = someErrorCode
      queryResult
    }

    driver.resetProbe()
  }

  "send request via InterFax SecureLounge" should {
    "successfully yield a fax document ID on valid request" in new Ctx {
      driver.aSendCharFaxFor(
        aSendCharFaxRequest()
      ) returns aSuccessfulSendCharFaxResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beSuccessful(value = ===(someTransactionId.toString))
    }

    "gracefully fail on error" in new Ctx {
      driver.aSendCharFaxFor(
        aSendCharFaxRequest()
      ) returns aFailedSendCharFaxResponse()

      fax.send(
        to = someTo,
        html = someFaxDocumentHtml) must beFailure[String, FaxErrorException](msg = contain(someErrorCode.toString))
    }
  }

  "retrieveStatus request via InterFax SecureLounge" should {
    "successfully yield a 'pending' status on valid request" in new Ctx {
      driver.aQueryListFor(
        aQueryListRequest()
      ) returns aPendingQueryResult()

      fax.retrieveStatus(
        documentId = someTransactionId.toString
      ) must beSuccessful(value = ===(Status.pending))
    }

    "successfully yield a 'sent' status on valid request" in new Ctx {
      driver.aQueryListFor(
        aQueryListRequest()
      ) returns aSentQueryResult()

      fax.retrieveStatus(
        documentId = someTransactionId.toString
      ) must beSuccessful(value = ===(Status.sent))
    }

    "successfully yield a 'failed' status on valid request" in new Ctx {
      driver.aQueryListFor(
        aQueryListRequest()
      ) returns aSendFailedQueryResult()

      fax.retrieveStatus(
        documentId = someTransactionId.toString
      ) must beSuccessful(value = ===(Status.failed))
    }

    "gracefully fail on error" in new Ctx {
      driver.aQueryListFor(
        aQueryListRequest()
      ) returns aFailedQueryResult()

      fax.retrieveStatus(
        documentId = someTransactionId.toString
      ) must beFailure[String, FaxErrorException](msg = contain(someErrorCode.toString))
    }
  }

  step {
    driver.stopProbe()
  }
}
