package com.wix.restaurants.fax.phaxio.model

/**
 * @see http://www.phaxio.com/docs/objects/
 */
case class Recipient(number: String,
                     status: String,
                     completed_at: Option[Long] = None,
                     error_type: Option[String] = None,
                     error_code: Option[String] = None)