package com.wix.fax.interfax.sl

import com.google.api.client.http.HttpRequestFactory
import com.wix.fax.FaxErrorException
import com.wix.fax.interfax.sl.model.StatusCode
import com.wix.fax.model.{Fax, Status}

import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

object Endpoints {
  /**
   * Secure Lounge endpoint for outbound PCI.
   * @see <a href="https://www.interfax.net/en/dev/secure_lounge/reference/soap/endpoint">Service Endpoint</a>
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
                    endpoint: String = Endpoints.production,
                    connectTimeout: Option[Duration] = None,
                    readTimeout: Option[Duration] = None,
                    numberOfRetries: Int = 0,
                    credentials: Credentials) extends Fax {

  private val interfaxsl = new InterfaxslClient(
    requestFactory = requestFactory,
    endpoint = endpoint,
    connectTimeout = connectTimeout,
    readTimeout = readTimeout,
    numberOfRetries = numberOfRetries,
    credentials = credentials
  )

  override def getId: String = InterfaxslFax.ID

  override def send(to: String, html: String): Try[String] = {
    interfaxsl.sendCharFax(to, html) match {
      case Success(transactionId) => Success(transactionId.toString)
      case Failure(e) => Failure(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatus(documentId: String): Try[String] = {
    interfaxsl.queryList(List(documentId.toLong)) match {
      case Success(faxItems) => Success(translateInterfaxStatusCode(faxItems.head.Status))
      case Failure(e) => Failure(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatuses(documentIds: Iterable[String]): Try[Map[String, String]] = {
    val transactionIds = documentIds.map { _.toLong }.toList
    interfaxsl.queryList(transactionIds) match {
      case Success(faxItems) =>
        Success(faxItems.map {
          faxItem => faxItem.TransactionID.toString -> translateInterfaxStatusCode(faxItem.Status)
        }.toMap)
      case Failure(e) => Failure(new FaxErrorException(e.getMessage, e))
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
