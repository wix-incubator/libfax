package com.wix.fax.concordfax.testkit


import scala.xml.{Node, XML}
import java.io.StringWriter
import akka.http.scaladsl.model.Uri.Path
import akka.http.scaladsl.model._
import com.google.api.client.util.Base64
import com.wix.e2e.http.api.StubWebServer
import com.wix.e2e.http.client.extractors.HttpMessageExtractors._
import com.wix.e2e.http.server.WebServerFactory._
import com.wix.fax.concordfax.Credentials
import com.wix.fax.concordfax.model.FileTypeIds


case class SendFaxResponse(`return`: Boolean, jobId: String, errorCode: Int, errorString: String)

class ConcordfaxDriver(port: Int) {
  private val server: StubWebServer = aStubWebServer.onPort(port).build

  def start(): Unit = server.start
  def stop(): Unit = server.stop
  def reset(): Unit = server.replaceWith()


  def aSimpleGetFaxStatusFor(credentials: Credentials, jobId: String): SimpleGetFaxStatusCtx = {
    new SimpleGetFaxStatusCtx(credentials, jobId)
  }

  def aSendFaxFor(credentials: Credentials, to: String, html: String): SendFaxCtx = {
    new SendFaxCtx(credentials, to, html)
  }


  abstract class Ctx {
    private def nodeToString(node: Node) = {
      val writer = new StringWriter()
      XML.write(writer, node, "UTF-8", xmlDecl = true, doctype = null)
      writer.toString
    }

    protected def returnsXml(responseXml: Node): Unit = {
      server.appendAll {
        case HttpRequest(
          HttpMethods.POST,
          Path("/"),
          _,
          entity,
          _) if isStubbedRequestEntity(entity) =>
            HttpResponse(
              status = StatusCodes.OK,
              entity = HttpEntity(ContentTypes.`text/xml(UTF-8)`, nodeToString(responseXml)))
      }
    }

    private def isStubbedRequestEntity(entity: HttpEntity): Boolean = {
      getRequestXml == entity.extractAsString
    }

    protected def getRequestXml: String
  }

  class SimpleGetFaxStatusCtx(credentials: Credentials, jobId: String) extends Ctx {
    def returns(status: Long): Unit = {
      returnsXml(
        <S:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
          <S:Body>
            <SimpleFaxStatusResponse xmlns="urn:FaxWS">
              <return>{status}</return>
            </SimpleFaxStatusResponse>
          </S:Body>
        </S:Envelope>
      )
    }

    protected override def getRequestXml: String = {
      "<?xml version=\"1.0\" ?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><SimpleGetFaxStatus xmlns=\"urn:FaxWS\">" +
        "<UserID>" + credentials.username + "</UserID>" +
        "<strPIN>" + credentials.password + "</strPIN>" +
        "<JobId>" + jobId + "</JobId>" +
        "</SimpleGetFaxStatus></S:Body></S:Envelope>"
    }
  }

  class SendFaxCtx(credentials: Credentials, to: String, html: String) extends Ctx {
    def returns(response: SendFaxResponse): Unit = {
      returnsXml(
        <S:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
          <S:Body>
            <FaxSendResponse xmlns="urn:FaxWS">
              <return>{response.`return`}</return>
              <FaxJobIds>
                <item>
                  <JobId>{response.jobId}</JobId>
                </item>
              </FaxJobIds>
              <WSError>
                <ErrorCode>{response.errorCode}</ErrorCode>
                <ErrorString>{response.errorString}</ErrorString>
              </WSError>
            </FaxSendResponse>
          </S:Body>
        </S:Envelope>)
    }

    protected override def getRequestXml: String = {
      "<?xml version=\"1.0\" ?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><SendFax xmlns=\"urn:FaxWS\">" +
        "<UserID>" + credentials.username + "</UserID>" +
        "<strPIN>" + credentials.password + "</strPIN>" +
        "<Recipients><item><RecipFaxNumber>" + to + "</RecipFaxNumber></item></Recipients>" +
        "<FaxJobFiles><item><FileIndex>1</FileIndex><FileTypeId>" + FileTypeIds.mhtml + "</FileTypeId><FileData>" + Base64.encodeBase64String(html.getBytes("UTF-8")) + "</FileData></item></FaxJobFiles>" +
        "</SendFax></S:Body></S:Envelope>"
    }
  }
}
