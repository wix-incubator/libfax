package com.wix.restaurants.fax.phaxio.model

/**
 * @see http://www.phaxio.com/docs/objects/
 */

//      {\"id\":10912328,
// \"num_pages\":1,\
// "cost\":5,
// \"direction\":\"sent\",
// \"status\":\"success\",
// \"is_test\":false,
// \"requested_at\":1430240392,
// \"completed_at\":1430240422,
// \"recipients\":[{\"number\":\"+972773180274\",\"status\":\"success\",\"bitrate\":\"9600\",\"resolution\":\"8040\",\"completed_at\":1430240422}]}

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