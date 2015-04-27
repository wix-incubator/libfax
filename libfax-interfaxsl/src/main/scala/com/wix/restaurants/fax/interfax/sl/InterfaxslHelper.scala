package com.wix.restaurants.fax.interfax.sl

import com.wix.restaurants.fax.interfax.sl.model.{FileType, SendCharFaxParams}

class InterfaxslHelper {
  def createSendCharFaxParams(credentials: Credentials, to: String, html: String): Map[String, String] = Map(
    SendCharFaxParams.username -> credentials.username,
    SendCharFaxParams.password -> credentials.password,
    SendCharFaxParams.faxNumber -> to,
    SendCharFaxParams.data -> html,
    SendCharFaxParams.fileType -> FileType.html
  )
}
