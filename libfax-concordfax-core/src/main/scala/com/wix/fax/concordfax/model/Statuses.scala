package com.wix.fax.concordfax.model

/**
 * @see <a href="https://developer.concordfax.com/ofd/html/4ad911b8-7eee-45a8-8a40-d288d85cccb1.htm">SimpleGetFaxStatus Method</a>
 */
object Statuses {
  val succeeded = 1L
  val failed = 2L
  val processed = 3L
  val invalidJobId = -5019L
}
