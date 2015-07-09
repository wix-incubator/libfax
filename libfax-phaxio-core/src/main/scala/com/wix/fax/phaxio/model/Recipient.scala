package com.wix.fax.phaxio.model

/**
 * @see <a href="http://www.phaxio.com/docs/objects/">Fax Recipient</a>
 */
case class Recipient(number: String,
                     status: String,
                     completed_at: Option[Long] = None,
                     error_type: Option[String] = None,
                     error_code: Option[String] = None)