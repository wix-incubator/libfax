package com.wix.fax.phaxio.model

/**
 * @see <a href="http://www.phaxio.com/docs/api/general/faxStatus/">Get status for a specific faxId</a>
 */
case class FaxStatusResponse(success: Boolean,
                             message: String,
                             data: Option[Fax] = None)
