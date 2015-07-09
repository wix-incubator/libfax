package com.wix.fax.phaxio.model

/**
 * @see <a href="http://www.phaxio.com/docs/objects/">Fax Object</a>
 */
case class Fax(id: Long,
               direction: String,
               num_pages: Int,
               cost: Int,
               status: String,
               is_test: Boolean,
               requested_at: Long,
               from_number: Option[String] = None,
               to_number: Option[String] = None,
               recipients: List[Recipient],
               tags: Option[Map[String, String]] = None,
               error_type: Option[String] = None,
               error_code: Option[String] = None,
               completed_at: Option[Long] = None)