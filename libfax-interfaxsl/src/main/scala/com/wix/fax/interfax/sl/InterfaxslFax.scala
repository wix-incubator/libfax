package com.wix.fax.interfax.sl

import com.google.api.client.http.HttpRequestFactory
import com.twitter.util.{Return, Throw, Try}
import com.wix.fax.FaxErrorException
import com.wix.fax.interfax.sl.model.StatusCode
import com.wix.fax.model.{Fax, Status}

import scala.concurrent.duration.Duration

object Endpoint {
  /**
   * Secure Lounge endpoint for outbound PCI.
   * @see http://www.interfax.net/en/solutions/pci_fax/outbound_pci
   */
  val production = "https://ws-sl.fax.tc/Outbound.asmx/"
}

object InterfaxslFax {
  val ID = "net.interfax.sl"
}

/**
 * InterFax SecureLounge client.
 *
 * HTML documents with Unicode characters must include a
 *   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 * in their head section (InterFax ignores <meta charset="utf-8">).
 */
class InterfaxslFax(requestFactory: HttpRequestFactory,
                    endpoint: String = Endpoint.production,
                    connectTimeout: Option[Duration] = None,
                    readTimeout: Option[Duration] = None,
                    credentials: Credentials) extends Fax {

  private val interfaxsl = new InterfaxslClient(
    requestFactory = requestFactory,
    endpoint = endpoint,
    connectTimeout = connectTimeout,
    readTimeout = readTimeout,
    credentials = credentials
  )

  override def getId: String = InterfaxslFax.ID

  override def send(to: String, html: String): Try[String] = {
    interfaxsl.sendCharFax(to, html) match {
      case Return(transactionId) => Return(transactionId.toString)
      case Throw(e) => Throw(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatus(documentId: String): Try[String] = {
    interfaxsl.queryList(List(documentId.toLong)) match {
      case Return(faxItems) => Return(translateInterfaxStatusCode(faxItems.head.Status))
      case Throw(e) => Throw(new FaxErrorException(e.getMessage, e))
    }
  }

  private def translateInterfaxStatusCode(statusCode: Int): String = {
    // @see http://www.interfax.net/en/dev/secure_lounge/reference/soap/statuscodes
    statusCode match {
      case StatusCode.ok => Status.sent
      case x if x < 0 => Status.pending
      case x if x > 0 => Status.failed
    }
  }
}
