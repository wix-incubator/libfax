package com.wix.restaurants.fax.interfax.sl.model

/**
 * @see http://www.interfax.net/en/dev/secure_lounge/reference/soap/helper_methods/getallerrorcodes
 */
object ErrorCode {
  val invalidRecipient = -112L

  val descriptions = Map(
    -1L -> "Transaction ID not found",
    -22L -> "Invalid Country",
    -111L -> "Developers can send to designated fax number only",
    invalidRecipient -> "Invalid recipient",
    -123L -> "Invalid content (data)",
    -150L -> "System error",
    -151L -> "Invalid hash key",
    -170L -> "Invalid email address",
    -310L -> "This operation is available to Primary users only / Primary user required",
    -448L -> "CDR data file does not exist",
    -520L -> "There is no dealer associated with specified DealerID",
    -545L -> "Password should be 4 to 16 characters long, containing 0-9, a-z and A-Z only",
    -546L -> "Time Zone name is not valid",
    -700L -> "Illegal data in QueryForm.TransactionID",
    -707L -> "A request was made for records past the search limit of 2000; A search will be limited when the field QueryForm.UserID will be left empty and one or more of the following: QueryForm.Subject is empty OR QueryForm.Status is empty",
    -709L -> "PP card does not exist",
    -710L -> "At least one of the two parameter QueryControl.ReturnItems,QueryControl.ReturnStats should be set to true",
    -712L -> "Transaction too old",
    -1002L -> "Mismatch between number of document types and number of document sizes",
    -1003L -> "Authentication error",
    -1004L -> "Invalid file type",
    -1005L -> "Transaction not found or under another user",
    -1007L -> "Invalid data size parameter",
    -1008L -> "Total sizes does not match filesdata length",
    -1009L -> "Fax Image not available",
    -1010L -> "Ambiguous Append switch",
    -1011L -> "Too many / frequent queries",
    -1030L -> "Invalid verb value",
    -1061L -> "Missing chunk data",
    -1062L -> "Invalid uploaded document",
    -1066L -> "Original transaction already has a chained one",
    -1077L -> "Invalid options XML",
    -1367L -> "Bad cover page data",
    -1368L -> "Bad inbound transaction descriptor",
    -2011L -> "Password should be 4 to 16 characters long, containing 0-9, a-z and A-Z only",
    -2012L -> "Time Zone name is not valid",
    -2014L -> "Invalid or non-existing user name",
    -2028L -> "Country ISO 3166 code is invalid",
    -3003L -> "Image does not exist",
    -3058L -> "Invalid IP address"
  )

}
