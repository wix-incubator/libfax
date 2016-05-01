package com.wix.fax.phaxio

import com.google.api.client.http.HttpRequestFactory
import com.wix.fax.FaxErrorException
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.phaxio.model.{Status => PhaxioStatus}

import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success, Try}

object Endpoints {
  val production = "https://api.phaxio.com/v1/"
}

object PhaxioFax {
  val ID = "com.phaxio"
}

/**
 * Phaxio client.
 */
class PhaxioFax(requestFactory: HttpRequestFactory,
                endpoint: String = Endpoints.production,
                connectTimeout: Option[Duration] = None,
                readTimeout: Option[Duration] = None,
                numberOfRetries: Int = 0,
                credentials: Credentials,
                cancelTimeout: Duration) extends Fax {
  private val phaxio = new PhaxioClient(
    requestFactory = requestFactory,
    endpoint = endpoint,
    connectTimeout = connectTimeout,
    readTimeout = readTimeout,
    numberOfRetries = numberOfRetries,
    credentials = credentials
  )

  override def getId: String = PhaxioFax.ID

  override def send(to: String, html: String): Try[String] = {
    phaxio.send(to, html, cancelTimeout) match {
      case Success(faxInfo) => Success(faxInfo.faxId.toString)
      case Failure(e) => Failure(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatus(documentId: String): Try[String] = {
    phaxio.faxStatus(documentId.toLong) match {
      case Success(fax) => Success(translatePhaxioStatusCode(fax.status))
      case Failure(e) => Failure(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatuses(documentIds: Iterable[String]): Try[Map[String, String]] = {
    Try {
      val result = new mutable.HashMap[String, String]
      for (documentId <- documentIds) {
        retrieveStatus(documentId) match {
          case Success(status) => result.put(documentId, status)
          case Failure(e) => throw e
        }
      }
      result.toMap
    }
  }

  private def translatePhaxioStatusCode(status: String): String = {
    // @see http://www.phaxio.com/docs/statuses/
    status match {
      case PhaxioStatus.queued|PhaxioStatus.pendingBatch|PhaxioStatus.inProgress => Status.pending
      case PhaxioStatus.success|PhaxioStatus.partialSuccess => Status.sent
      case PhaxioStatus.failure => Status.failed
    }
  }
}
