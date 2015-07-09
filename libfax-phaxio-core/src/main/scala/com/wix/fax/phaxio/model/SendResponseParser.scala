package com.wix.fax.phaxio.model

import org.json4s.DefaultFormats
import org.json4s.native.Serialization

class SendResponseParser {
  implicit val formats = DefaultFormats

  def stringify(obj: SendResponse): String = {
    Serialization.write(obj)
  }

  def parse(json: String): SendResponse = {
    Serialization.read[SendResponse](json)
  }
}
