package com.target.targetcasestudy.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DealResponse(
  @Json(name = "products")
  val deals: List<Deal>
)