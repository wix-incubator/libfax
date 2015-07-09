package com.wix.fax.phaxio.model

/**
 * @see <a href="http://www.phaxio.com/docs/statuses/">Statuses</a>
 */
object Status {
  /** The operation is currently in a queue on a server and should be executed very soon. */
  val queued = "queued"

  /** The fax is in batching mode. It is currently open to accepting more files for its recipients. */
  val pendingBatch = "pendingbatch"

  /** The system is in the middle of the job and communicating with the fax machine. */
  val inProgress = "inprogress"

  /**
   * The fax operation succeeded. Everything went as normally planned.
   * For a sent fax, this means all recipients received the fax successfully.
   */
  val success = "success"

  /**
   * The fax operation failed. Details of the error can be found in the error_code field.
   * For a sent fax, this means that NONE of the recipients received the fax.
   */
  val failure = "failure"

  /**
   * The job partially succeeded. Details of what went wrong can be found in the error_code field.
   * For a sent fax, this usually means that SOME of the recipients received the fax, but not all.
   */
  val partialSuccess = "partialsuccess"
}
