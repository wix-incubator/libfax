package com.wix.fax.phaxio

import com.wix.fax.phaxio.model.{Params, StringDataType}

import scala.concurrent.duration.Duration

object PhaxioHelper {
  def createSendParams(credentials: Credentials, to: String, html: String, cancelTimeout: Duration): Map[String, String] = Map(
    Params.apiKey -> credentials.key,
    Params.apiSecret -> credentials.secret,
    Params.to -> to,
    Params.stringData -> html,
    Params.stringDataType -> StringDataType.html,
    Params.batch -> false.toString,
    Params.batchDelay -> 0.toString,
    Params.batchCollisionAvoidance -> false.toString,
    Params.callbackUrl -> "",
    Params.cancelTimeout -> cancelTimeout.toMinutes.toString,
    Params.callerId -> ""
  )

  def createFaxStatusParams(credentials: Credentials, id: Long): Map[String, String] = Map(
    Params.apiKey -> credentials.key,
    Params.apiSecret -> credentials.secret,
    Params.id -> id.toString
  )
}
