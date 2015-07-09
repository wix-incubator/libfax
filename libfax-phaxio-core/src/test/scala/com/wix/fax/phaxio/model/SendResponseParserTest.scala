package com.wix.fax.phaxio.model

import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope

class SendResponseParserTest extends SpecWithJUnit {
  trait Ctx extends Scope {
    val someSendResponse = SendResponse(
      success = true,
      message = "some message",
      faxId = Some(123L),
      data = Some(FaxInfo(
        faxId = 456L
      ))
    )

    val parser = new SendResponseParser
  }

  "stringify and then parse" should {
    "yield an object similar to the original one" in new Ctx {
      val json = parser.stringify(someSendResponse)
      parser.parse(json) must beEqualTo(someSendResponse)
    }
  }
}
