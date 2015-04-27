package com.wix.restaurants.fax.interfax.sl.model

/**
 * @see http://www.interfax.net/en/dev/secure_lounge/reference/soap/helper_methods/getallerrorcodes
 */
object ErrorCode {
  val ok = 0
  val invalidRecipient = -112

  val descriptions = Map(
    ok -> "OK",
    -1 -> "Transaction ID not found",
    -22 -> "Invalid Country",
    -111 -> "Developers can send to designated fax number only",
    invalidRecipient -> "Invalid recipient",
    -123 -> "Invalid content (data)",
    -150 -> "System error",
    -151 -> "Invalid hash key",
    -170 -> "Invalid email address",
    -310 -> "This operation is available to Primary users only / Primary user required",
    -448 -> "CDR data file does not exist",
    -520 -> "There is no dealer associated with specified DealerID",
    -545 -> "Password should be 4 to 16 characters long, containing 0-9, a-z and A-Z only",
    -546 -> "Time Zone name is not valid",
    -700 -> "Illegal data in QueryForm.TransactionID",
    -707 -> "A request was made for records past the search limit of 2000; A search will be limited when the field QueryForm.UserID will be left empty and one or more of the following: QueryForm.Subject is empty OR QueryForm.Status is empty",
    -709 -> "PP card does not exist",
    -710 -> "At least one of the two parameter QueryControl.ReturnItems,QueryControl.ReturnStats should be set to true",
    -712 -> "Transaction too old",
    -1002 -> "Mismatch between number of document types and number of document sizes",
    -1003 -> "Authentication error",
    -1004 -> "Invalid file type",
    -1005 -> "Transaction not found or under another user",
    -1007 -> "Invalid data size parameter",
    -1008 -> "Total sizes does not match filesdata length",
    -1009 -> "Fax Image not available",
    -1010 -> "Ambiguous Append switch",
    -1011 -> "Too many / frequent queries",
    -1030 -> "Invalid verb value",
    -1061 -> "Missing chunk data",
    -1062 -> "Invalid uploaded document",
    -1066 -> "Original transaction already has a chained one",
    -1077 -> "Invalid options XML",
    -1367 -> "Bad cover page data",
    -1368 -> "Bad inbound transaction descriptor",
    -2011 -> "Password should be 4 to 16 characters long, containing 0-9, a-z and A-Z only",
    -2012 -> "Time Zone name is not valid",
    -2014 -> "Invalid or non-existing user name",
    -2028 -> "Country ISO 3166 code is invalid",
    -3003 -> "Image does not exist",
    -3058 -> "Invalid IP address"
  )

}
