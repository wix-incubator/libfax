package com.wix.restaurants.fax.phaxio.model

/**
 * @see http://www.phaxio.com/docs/api/general/faxStatus/
 */
case class FaxStatusResponse(success: Boolean,
                             message: String,
                             data: Option[Fax] = None)
