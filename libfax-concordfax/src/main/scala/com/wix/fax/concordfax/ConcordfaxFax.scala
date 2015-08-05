package com.wix.fax.concordfax

import javax.xml.namespace.QName
import javax.xml.ws.{BindingProvider, Holder}

import com.concordfax._
import com.twitter.util.{Return, Throw, Try}
import com.wix.fax.concordfax.model.{FileTypeIds, Statuses}
import com.wix.fax.model.{Fax, Status}
import com.wix.fax.{FaxErrorException, FaxException}

import scala.collection.mutable

object Endpoint {
  val production = "https://ws.concordfax.com/fax/v5"
}

object ConcordfaxFax {
  val ID = "com.concordfax"
}

/** Concord Fax client. */
class ConcordfaxFax(endpoint: String = Endpoint.production,
                    credentials: Credentials) extends Fax {
  /**
   * Creates a web-service port without downloading the WSDL.
   * @see <a href="http://stackoverflow.com/a/25855467/929444">Instantiate JAX-WS service without downloading WSDL?</a>
   *
   * Web-service classes were auto-generted from https://ws.concordfax.com/fax/v5/FaxWS.wsdl using:
   * wsimport -s src -p com.concordfax -verbose https://ws.concordfax.com/fax/v5/faxws.wsdl
   */
  private def createWs(): FaxWSPortType = {
    val ws = new FaxWS(
      ConcordfaxFax.getClass.getResource("/FaxWS.wsdl"),
      new QName("https://ws.concordfax.com/fax/v5/FaxWS.wsdl", "FaxWS")
    )
    val port = ws.getPort(classOf[FaxWSPortType])

    val bindingProvider = port.asInstanceOf[BindingProvider]
    bindingProvider.getRequestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint)

    port
  }
  private val concordfax = createWs()

  override def getId: String = ConcordfaxFax.ID

  override def send(to: String, html: String): Try[String] = {
    Try {
      // Configure recipient
      val recipient = new FaxJobRecipient
      recipient.setRecipFaxNumber(to)

      val recipients = new FaxJobRecipients
      recipients.getItem.add(recipient)

      // Configure file
      val file = new FaxJobFile
      file.setFileIndex(1) // 1-based according to https://developer.concordfax.com/ofd/html/d49687aa-c1cc-4682-851c-09595645d92a.htm
      file.setFileTypeId(FileTypeIds.mhtml)
      file.setFileData(html.getBytes("UTF-8"))

      val files = new FaxJobFiles
      files.getItem.add(file)

      // Call web service
      val jobIds = new Holder[FaxJobIds]
      val wsError = new Holder[WSError]

      if (concordfax.sendFax(credentials.username, credentials.password, recipients, files, jobIds, null, wsError)) {
        jobIds.value.getItem.get(0).getJobId
      } else {
        throw new FaxErrorException(s"${wsError.value.getErrorCode}|${wsError.value.getErrorString}")
      }
    } match {
      case Return(jobId) => Return(jobId)
      case Throw(e: FaxException) => Throw(e)
      case Throw(e) => Throw(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatus(documentId: String): Try[String] = {
    Try {
      val status = concordfax.simpleGetFaxStatus(credentials.username, credentials.password, documentId)

      // @see <a href="https://developer.concordfax.com/ofd/html/4ad911b8-7eee-45a8-8a40-d288d85cccb1.htm">SimpleGetFaxStatus Method</a>
      status match {
        case Statuses.succeeded => Status.sent
        case Statuses.failed => Status.failed
        case Statuses.processed => Status.pending
        case Statuses.invalidJobId => throw new FaxErrorException(s"Invalid ConcordFax job ID: $documentId")
        case _ => throw new FaxErrorException(s"Unknown ConcordFax status code: $status")
      }
    } match {
      case Return(jobId) => Return(jobId)
      case Throw(e: FaxException) => Throw(e)
      case Throw(e) => Throw(new FaxErrorException(e.getMessage, e))
    }
  }

  override def retrieveStatuses(documentIds: Iterable[String]): Try[Map[String, String]] = {
    // Naive implementation using multiple calls to retrieveStatus.
    // Optimization: use concordfax.getFaxStatus to query multiple document IDs at once.
    Try {
      val result = new mutable.HashMap[String, String]
      for (documentId <- documentIds) {
        retrieveStatus(documentId) match {
          case Return(status) => result.put(documentId, status)
          case Throw(e) => throw e
        }
      }
      result.toMap
    }
  }
}
