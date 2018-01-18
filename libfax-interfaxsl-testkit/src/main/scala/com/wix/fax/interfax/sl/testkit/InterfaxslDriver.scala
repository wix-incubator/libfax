package com.wix.fax.interfax.sl.testkit


import scala.collection.JavaConversions._
import scala.collection.mutable
import java.util.{List => JList}
import akka.http.scaladsl.model.Uri.Path
import akka.http.scaladsl.model._
import com.google.api.client.http.UrlEncodedParser
import com.wix.e2e.http.api.StubWebServer
import com.wix.e2e.http.client.extractors.HttpMessageExtractors._
import com.wix.e2e.http.server.WebServerFactory.aStubWebServer
import com.wix.fax.interfax.sl.model.{QueryResult, QueryResultParser, SendCharFaxResponse, SendCharFaxResponseParser}


class InterfaxslDriver(port: Int) {
  private val server: StubWebServer = aStubWebServer.onPort(port).build

  def start(): Unit = server.start
  def stop(): Unit = server.stop
  def reset(): Unit = server.replaceWith()


  def aSendCharFaxFor(params: Map[String, String]): SendCharFaxCtx = new SendCharFaxCtx(params)

  def aQueryListFor(params: Map[String, String]): QueryListCtx = new QueryListCtx(params)


  abstract class Ctx(resource: String, params: Map[String, String]) {
    protected def returnsXml(responseXml: String): Unit = {
      server.appendAll {
        case HttpRequest(
          HttpMethods.POST,
          Path(`resource`),
          _,
          entity,
          _) if isStubbedRequestEntity(entity) =>
            HttpResponse(
              status = StatusCodes.OK,
              entity = HttpEntity(ContentType(MediaTypes.`text/xml`, HttpCharsets.`UTF-8`), responseXml))
      }
    }

    private def isStubbedRequestEntity(entity: HttpEntity): Boolean = {
      val requestParams = urlDecode(entity.extractAsString)

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
      returnsXml(SendCharFaxResponseParser.stringify(sendCharFaxResponse))
    }
  }

  class QueryListCtx(params: Map[String, String]) extends Ctx("/QueryList", params) {
    def returns(queryResult: QueryResult): Unit = {
      returnsXml(QueryResultParser.stringify(queryResult))
    }
  }
}
