package com.wix.restaurants.fax.phaxio.model

/**
 * @see http://www.phaxio.com/docs/api/send/sendFax/
 */
case class SendResponse(success: Boolean,
                        message: String,
                        faxId: Option[Long] = None,
                        data: Option[FaxInfo] = None)