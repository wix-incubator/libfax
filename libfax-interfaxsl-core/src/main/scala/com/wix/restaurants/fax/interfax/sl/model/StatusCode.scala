package com.wix.restaurants.fax.interfax.sl.model

/**
 * @see http://www.interfax.net/en/dev/secure_lounge/reference/soap/statuscodes
 */
object StatusCode {
  /** The fax has been prepared and is awaiting its turn in the outbound queue. */
  val ready = -2

  /**
   * Your fax has been sent successfully. Note that this confirmation is provided by the receiving fax machine,
   * indicating it confirms that it has received all pages successfully.
   */
  val ok = 0

  /** The receiving line is in use. */
  val busy = 263
}
