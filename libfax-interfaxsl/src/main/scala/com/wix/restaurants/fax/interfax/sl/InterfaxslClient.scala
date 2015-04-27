package com.wix.restaurants.fax.interfax.sl

import com.google.api.client.http.{GenericUrl, HttpRequestFactory, HttpResponse, UrlEncodedContent}
import com.twitter.util.{Return, Throw, Try}
import com.wix.restaurants.fax.interfax.sl.model.{ErrorCode, SendCharFaxResponseParser}

import scala.collection.JavaConversions._
import scala.concurrent.duration.Duration

class InterfaxslClient(requestFactory: HttpRequestFactory,
                       endpoint: String,
                       connectTimeout: Option[Duration] = None,
                       readTimeout: Option[Duration] = None,
                       credentials: Credentials) {
  private val helper = new InterfaxslHelper
  private val sendCharFaxResponseParser = new SendCharFaxResponseParser

  def sendCharFax(to: String, html: String): Try[Long] = {
    val params = helper.createSendCharFaxParams(
      credentials = credentials,
      to = to,
      html = html
    )

    val httpRequest = requestFactory.buildPostRequest(
      new GenericUrl(endpoint + "SendCharFax"),
      new UrlEncodedContent(mapAsJavaMap(params))
    )

    connectTimeout foreach (connectTimeout => httpRequest.setConnectTimeout(connectTimeout.toMillis.toInt))
    readTimeout foreach (readTimeout => httpRequest.setReadTimeout(readTimeout.toMillis.toInt))

    val httpResponse = httpRequest.execute()
    val responseXml = extractAndCloseResponse(httpResponse)
    val sendCharFaxResponse = sendCharFaxResponseParser.parse(responseXml)

    if (sendCharFaxResponse.value < 0) {
      Throw(translateInterfaxslError(sendCharFaxResponse.value))
    } else {
      Return(sendCharFaxResponse.value)
    }
  }

  private def extractAndCloseResponse(httpResponse: HttpResponse): String = {
    try {
      httpResponse.parseAsString()
    } finally {
      httpResponse.ignore()
    }
  }

  private def translateInterfaxslError(errorCode: Long): InterfaxslException = {
    new InterfaxslException(s"Interfax SecureLounge error $errorCode: ${ErrorCode.descriptions.getOrElse(errorCode, "Unknown error")}")
  }
}
