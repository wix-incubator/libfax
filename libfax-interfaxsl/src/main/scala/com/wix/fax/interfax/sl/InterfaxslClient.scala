package com.wix.fax.interfax.sl

import com.google.api.client.http.{GenericUrl, HttpRequestFactory, HttpResponse, UrlEncodedContent}
import com.twitter.util.{Return, Throw, Try}
import com.wix.fax.interfax.sl.model.{ErrorCode, FaxItemEx, QueryResultParser, SendCharFaxResponseParser}

import scala.collection.JavaConversions._
import scala.concurrent.duration.Duration

class InterfaxslClient(requestFactory: HttpRequestFactory,
                       endpoint: String,
                       connectTimeout: Option[Duration] = None,
                       readTimeout: Option[Duration] = None,
                       credentials: Credentials) {
  private val helper = new InterfaxslHelper
  private val sendCharFaxResponseParser = new SendCharFaxResponseParser
  private val queryResultParser = new QueryResultParser

  def sendCharFax(to: String, html: String): Try[Long] = {
    val params = helper.createSendCharFaxParams(
      credentials = credentials,
      to = to,
      html = html
    )

    val responseXml = doRequest("SendCharFax", params)
    val sendCharFaxResponse = sendCharFaxResponseParser.parse(responseXml)

    if (sendCharFaxResponse.value < 0) {
      Throw(translateInterfaxslError(sendCharFaxResponse.value.toInt))
    } else {
      Return(sendCharFaxResponse.value)
    }
  }

  def queryList(transactionIds: List[Long]): Try[List[FaxItemEx]] = {
    val params = helper.createQueryListParams(
      credentials = credentials,
      transactionIds = transactionIds
    )

    val responseXml = doRequest("QueryList", params)
    val queryResult = queryResultParser.parse(responseXml)

    if (queryResult.ResultCode < 0) {
      Throw(translateInterfaxslError(queryResult.ResultCode))
    } else {
      Return(queryResult.FaxItems.FaxItem.toList)
    }
  }

  private def doRequest(resource: String, params: Map[String, String]): String = {
    val httpRequest = requestFactory.buildPostRequest(
      new GenericUrl(endpoint + resource),
      new UrlEncodedContent(mapAsJavaMap(params))
    )

    connectTimeout foreach (connectTimeout => httpRequest.setConnectTimeout(connectTimeout.toMillis.toInt))
    readTimeout foreach (readTimeout => httpRequest.setReadTimeout(readTimeout.toMillis.toInt))

    val httpResponse = httpRequest.execute()
    extractAndCloseResponse(httpResponse)
  }

  private def extractAndCloseResponse(httpResponse: HttpResponse): String = {
    try {
      httpResponse.parseAsString()
    } finally {
      httpResponse.ignore()
    }
  }

  private def translateInterfaxslError(errorCode: Int): InterfaxslException = {
    new InterfaxslException(s"Interfax SecureLounge error $errorCode: ${ErrorCode.descriptions.getOrElse(errorCode, "Unknown error")}")
  }
}
