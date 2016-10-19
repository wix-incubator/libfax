package com.wix.fax.interfax.sl

import com.google.api.client.http.{GenericUrl, HttpRequestFactory, HttpResponse, UrlEncodedContent}
import com.wix.fax.interfax.sl.model.{ErrorCode, FaxItemEx, QueryResultParser, SendCharFaxResponseParser}

import scala.collection.JavaConversions._
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

class InterfaxslClient(requestFactory: HttpRequestFactory,
                       endpoint: String,
                       connectTimeout: Option[Duration] = None,
                       readTimeout: Option[Duration] = None,
                       numberOfRetries: Int = 0,
                       credentials: Credentials) {
  def sendCharFax(to: String, html: String): Try[Long] = {
    val params = InterfaxslHelper.createSendCharFaxParams(
      credentials = credentials,
      to = to,
      html = html
    )

    val responseXml = doRequest("SendCharFax", params)
    val sendCharFaxResponse = SendCharFaxResponseParser.parse(responseXml)

    if (sendCharFaxResponse.value < 0) {
      Failure(translateInterfaxslError(sendCharFaxResponse.value.toInt))
    } else {
      Success(sendCharFaxResponse.value)
    }
  }

  def queryList(transactionIds: List[Long]): Try[List[FaxItemEx]] = {
    val params = InterfaxslHelper.createQueryListParams(
      credentials = credentials,
      transactionIds = transactionIds
    )

    val responseXml = doRequest("QueryList", params)
    val queryResult = QueryResultParser.parse(responseXml)

    if (queryResult.ResultCode < 0) {
      Failure(translateInterfaxslError(queryResult.ResultCode))
    } else {
      Success(queryResult.FaxItems.FaxItem.toList)
    }
  }

  private def doRequest(resource: String, params: Map[String, String]): String = {
    val httpRequest = requestFactory.buildPostRequest(
      new GenericUrl(endpoint + resource),
      new UrlEncodedContent(mapAsJavaMap(params))
    )

    connectTimeout foreach (connectTimeout => httpRequest.setConnectTimeout(connectTimeout.toMillis.toInt))
    readTimeout foreach (readTimeout => httpRequest.setReadTimeout(readTimeout.toMillis.toInt))
    httpRequest.setNumberOfRetries(numberOfRetries)

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
    InterfaxslException(s"Interfax SecureLounge error $errorCode: ${ErrorCode.descriptions.getOrElse(errorCode, "Unknown error")}")
  }
}
