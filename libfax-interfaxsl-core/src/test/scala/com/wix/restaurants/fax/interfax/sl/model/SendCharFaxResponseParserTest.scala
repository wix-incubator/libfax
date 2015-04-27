package com.wix.restaurants.fax.interfax.sl.model

import java.lang.{Long => JLong}

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.specification.Scope

class SendCharFaxResponseParserTest extends SpecificationWithJUnit {
  trait Ctx extends Scope {
    val someResponse = new SendCharFaxResponse()
    someResponse.value = 123L

    val parser = new SendCharFaxResponseParser
  }

  "stringify and then parse" should {
    "yield an object similar to the original one" in new Ctx {
      val xml = parser.stringify(someResponse)
      parser.parse(xml) must beEqualTo(someResponse)
    }
  }
}
