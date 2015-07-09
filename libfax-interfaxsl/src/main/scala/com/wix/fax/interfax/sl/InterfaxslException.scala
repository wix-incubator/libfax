package com.wix.fax.interfax.sl

/** An exception raised by InterFax SecureLounge. */
case class InterfaxslException(message: String = null, cause: Throwable = null) extends RuntimeException(message, cause)
