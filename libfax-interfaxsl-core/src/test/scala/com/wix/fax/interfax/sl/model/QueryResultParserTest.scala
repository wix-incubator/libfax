package com.wix.fax.interfax.sl.model

import java.math.BigDecimal
import java.util

import org.specs2.mutable.SpecWithJUnit
import org.specs2.specification.Scope

class QueryResultParserTest extends SpecWithJUnit {
  trait Ctx extends Scope {
    private def createFaxItemEx() = {
      val faxItemEx = new FaxItemEx

      faxItemEx.TransactionID = 123L
      faxItemEx.SubmitTime = "some submit time"
      faxItemEx.CompletionTime = "some completion time"
      faxItemEx.UserID = "some user id"
      faxItemEx.Contact = "some contact"
      faxItemEx.DestinationFax = "some destination fax"
      faxItemEx.RemoteCSID = "some remoteCSID"
      faxItemEx.PagesSent = 7.asInstanceOf[Short]
      faxItemEx.Status = StatusCode.ok
      faxItemEx.Duration = 10
      faxItemEx.Subject = "some subject"
      faxItemEx.PagesSubmitted = 7.asInstanceOf[Short]
      faxItemEx.SenderCSID = "some senderCSID"
      faxItemEx.Priority = 3.asInstanceOf[Short]
      faxItemEx.Units = BigDecimal.valueOf(20)
      faxItemEx.CostPerUnit = BigDecimal.valueOf(0.05)
      faxItemEx.PageSize = PageSize.a4
      faxItemEx.PageOrientation = PageOrientation.portrait
      faxItemEx.PageResolution = PageResolution.standard
      faxItemEx.RenderingQuality = RenderingQuality.standard
      faxItemEx.PageHeader = "some page header"
      faxItemEx.RetriesToPerform = 1.asInstanceOf[Short]
      faxItemEx.TrialsPerformed = 1.asInstanceOf[Short]
      faxItemEx.LocaleID = 8
      faxItemEx.GMTBias = 3
      faxItemEx.RetriesInterval = 3
      faxItemEx.UserData = "some user data"

      faxItemEx
    }

    private def createQueryResult() = {
      val queryResult = new QueryResult
      queryResult.ResultCode = ErrorCode.ok
      queryResult.FaxItems = new FaxItems
      queryResult.FaxItems.FaxItem = new util.LinkedList[FaxItemEx]()
      queryResult.FaxItems.FaxItem.add(createFaxItemEx())
      queryResult.FaxItems.FaxItem.add(createFaxItemEx())
      queryResult
    }

    val someQueryResult = createQueryResult()
  }

  "stringify and then parse" should {
    "yield an object similar to the original one" in new Ctx {
      val xml = QueryResultParser.stringify(someQueryResult)
      QueryResultParser.parse(xml) must beEqualTo(someQueryResult)
    }
  }
}
