package com.wix.fax.phaxio.testkit

import java.util.{List => JList}

import com.google.api.client.http.UrlEncodedParser
import com.wix.fax.phaxio.model.{FaxStatusResponse, FaxStatusResponseParser, SendResponse, SendResponseParser}
import com.wix.hoopoe.http.testkit.EmbeddedHttpProbe
import spray.http._

import scala.collection.JavaConversions._
import scala.collection.mutable

class PhaxioDriver(port: Int) {
  private val probe = new EmbeddedHttpProbe(port, EmbeddedHttpProbe.NotFoundHandler)

  def startProbe() {
    probe.doStart()
  }

  def stopProbe() {
    probe.doStop()
  }

  def resetProbe() {
    probe.handlers.clear()
  }

  def aSendFor(params: Map[String, String]): SendCtx = {
    new SendCtx(params)
  }

  def aFaxStatusFor(params: Map[String, String]): FaxStatusCtx = {
    new FaxStatusCtx(params)
  }

  abstract class Ctx(resource: String, params: Map[String, String]) {
    protected def returnsJson(responseJson: String): Unit = {
      probe.handlers += {
        case HttpRequest(
        HttpMethods.POST,
        Uri.Path(`resource`),
        _,
        entity,
        _) if isStubbedRequestEntity(entity) =>
          HttpResponse(
            status = StatusCodes.OK,
            entity = HttpEntity(ContentTypes.`application/json`, responseJson))
      }
    }

    private def isStubbedRequestEntity(entity: HttpEntity): Boolean = {
      val requestParams = urlDecode(entity.asString)

      params.forall {
        case (k, v) => requestParams.contains(k) && (v == requestParams(k))
      }
    }

    private def urlDecode(str: String): Map[String, String] = {
      val params = mutable.LinkedHashMap[String, JList[String]]()
      UrlEncodedParser.parse(str, mutableMapAsJavaMap(params))
      params.mapValues( _(0) ).toMap
    }
  }

  class SendCtx(params: Map[String, String]) extends Ctx("/send", params) {
    def returns(sendResponse: SendResponse): Unit = {
      returnsJson(SendResponseParser.stringify(sendResponse))
    }
  }

  class FaxStatusCtx(params: Map[String, String]) extends Ctx("/faxStatus", params) {
    def returns(faxStatusResponse: FaxStatusResponse): Unit = {
      returnsJson(FaxStatusResponseParser.stringify(faxStatusResponse))
    }
  }
}
