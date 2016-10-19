package com.wix.fax.interfax.sl.model

import java.lang.{Long => JLong}

import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope

class SendCharFaxResponseParserTest extends SpecWithJUnit {
  trait Ctx extends Scope {
    val someResponse = new SendCharFaxResponse()
    someResponse.value = 123L
  }

  "stringify and then parse" should {
    "yield an object similar to the original one" in new Ctx {
      val xml = SendCharFaxResponseParser.stringify(someResponse)
      SendCharFaxResponseParser.parse(xml) must beEqualTo(someResponse)
    }
  }
}
