package com.wix.restaurants.fax.interfax.sl

import com.google.api.client.http.HttpRequestFactory
import com.twitter.util.{Return, Throw, Try}
import com.wix.restaurants.fax.FaxErrorException
import com.wix.restaurants.fax.model.Fax

import scala.concurrent.duration.Duration

object Endpoint {
  /**
   * Secure Lounge endpoint for outbound PCI.
   * @see http://www.interfax.net/en/solutions/pci_fax/outbound_pci
   */
  val production = "https://ws-sl.fax.tc/Outbound.asmx/"
}

object Interfaxsl {
  val ID = "net.interfax.sl"
}

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

  override def getId: String = Interfaxsl.ID

  override def send(to: String, html: String): Try[String] = {
    interfaxsl.sendCharFax(to, html) match {
      case Return(transactionId) => Return(transactionId.toString)
      case Throw(e) => Throw(new FaxErrorException(e.getMessage, e))
    }
  }

  // TODO: implement
  override def retrieveStatus(documentId: String): Try[String] = ???
}
