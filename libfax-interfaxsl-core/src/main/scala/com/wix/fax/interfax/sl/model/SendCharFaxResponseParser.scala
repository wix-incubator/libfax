package com.wix.fax.interfax.sl.model

import java.io.{StringReader, StringWriter}
import javax.xml.bind.JAXBContext

object SendCharFaxResponseParser {
  private val context = JAXBContext.newInstance(classOf[SendCharFaxResponse])
  private val marshaller = context.createMarshaller()
  private val unmarshaller = context.createUnmarshaller()

  def stringify(obj: SendCharFaxResponse): String = {
    val writer = new StringWriter()
    try {
      marshaller.marshal(obj, writer)
    } finally {
      writer.close()
    }
    writer.toString
  }

  def parse(xml: String): SendCharFaxResponse = {
    val reader = new StringReader(xml)
    try {
      unmarshaller.unmarshal(reader).asInstanceOf[SendCharFaxResponse]
    } finally {
      reader.close()
    }
  }
}
