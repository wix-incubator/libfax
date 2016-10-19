package com.wix.fax.interfax.sl

import com.wix.fax.interfax.sl.model.{FileType, Params}

object InterfaxslHelper {
  def createSendCharFaxParams(credentials: Credentials, to: String, html: String): Map[String, String] = Map(
    Params.username -> credentials.username,
    Params.password -> credentials.password,
    Params.faxNumber -> to,
    Params.data -> html,
    Params.fileType -> FileType.html
  )

  def createQueryListParams(credentials: Credentials, transactionIds: List[Long]): Map[String, String] = Map(
    Params.username -> credentials.username,
    Params.password -> credentials.password,
    Params.transactionList -> transactionIds.mkString(",")
  )
}
