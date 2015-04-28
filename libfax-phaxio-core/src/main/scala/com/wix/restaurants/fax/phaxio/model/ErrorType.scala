package com.wix.restaurants.fax.phaxio.model

/**
 * @see http://www.phaxio.com/docs/errorMessages/
 */
object ErrorType {
  /** documentConversionErrors usually occur when there is a problem with one of the files you posted. */
  val documentConversionError = "documentConversionError"

  /** There was a problem with the phone line. The call could not be placed. */
  val lineError = "lineError"

  /** A problem occured during the fax communication process. */
  val faxError = "faxError"

  /** Something went wrong internally on our systems. This should occur very infrequently. */
  val fatalError = "fatalError"

  /**
   * Similar to fatalError but higher priority. As soon as one of these occurs, rest assured that we're looking into it
   * immediately and will follow up with what went wrong.
   */
  val generalError = "generalError"
}
