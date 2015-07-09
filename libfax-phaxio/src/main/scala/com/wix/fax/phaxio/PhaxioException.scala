package com.wix.fax.phaxio

/** An exception raised by Phaxio. */
case class PhaxioException(message: String = null, cause: Throwable = null) extends RuntimeException(message, cause)
