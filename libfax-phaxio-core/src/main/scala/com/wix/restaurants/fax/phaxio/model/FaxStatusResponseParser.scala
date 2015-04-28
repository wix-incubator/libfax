package com.wix.restaurants.fax.phaxio.model

import org.json4s.DefaultFormats
import org.json4s.native.Serialization

class FaxStatusResponseParser {
  implicit val formats = DefaultFormats

  def stringify(obj: FaxStatusResponse): String = {
    Serialization.write(obj)
  }

  def parse(json: String): FaxStatusResponse = {
    Serialization.read[FaxStatusResponse](json)
  }
}
