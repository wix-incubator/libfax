package com.wix.fax.phaxio.model

/**
 * @see <a href="http://www.phaxio.com/docs/api/send/sendFax/">Send a fax</a>
 */
case class SendResponse(success: Boolean,
                        message: String,
                        faxId: Option[Long] = None,
                        data: Option[FaxInfo] = None)