package com.wix.restaurants.fax.interfax.sl.testkit

import java.util.{List => JList}

import com.google.api.client.http.UrlEncodedParser
import com.wix.restaurants.fax.interfax.sl.model.{QueryResult, QueryResultParser, SendCharFaxResponse, SendCharFaxResponseParser}
import com.wixpress.framework.test.http.EmbeddedHttpProbe
import spray.http._

import scala.collection.JavaConversions._
import scala.collection.mutable

class InterfaxslDriver(port: Int) {
  private val probe = new EmbeddedHttpProbe(port, EmbeddedHttpProbe.NotFoundHandler)
  private val sendCharFaxResponseParser = new SendCharFaxResponseParser
  private val queryResultParser = new QueryResultParser

  def startProbe() {
    probe.doStart()
  }

  def stopProbe() {
    probe.doStop()
  }

  def resetProbe() {
    probe.handlers.clear()
  }

  def aSendCharFaxFor(params: Map[String, String]): SendCharFaxCtx = {
    new SendCharFaxCtx(params)
  }

  def aQueryListFor(params: Map[String, String]): QueryListCtx = {
    new QueryListCtx(params)
  }

  abstract class Ctx(resource: String, params: Map[String, String]) {
    protected def returnsXml(responseXml: String): Unit = {
      probe.handlers += {
        case HttpRequest(
        HttpMethods.POST,
        Uri.Path(`resource`),
        _,
        entity,
        _) if isStubbedRequestEntity(entity) =>
          HttpResponse(
            status = StatusCodes.OK,
            entity = HttpEntity(ContentType(MediaTypes.`text/xml`, HttpCharsets.`UTF-8`), responseXml))
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

  class SendCharFaxCtx(params: Map[String, String]) extends Ctx("/SendCharFax", params) {
    def returns(sendCharFaxResponse: SendCharFaxResponse): Unit = {
      returnsXml(sendCharFaxResponseParser.stringify(sendCharFaxResponse))
    }
  }

  class QueryListCtx(params: Map[String, String]) extends Ctx("/QueryList", params) {
    def returns(queryResult: QueryResult): Unit = {
      returnsXml(queryResultParser.stringify(queryResult))
    }
  }
}
