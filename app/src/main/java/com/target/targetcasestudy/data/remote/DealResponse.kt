package com.target.targetcasestudy.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.target.targetcasestudy.api.Deal

@JsonClass(generateAdapter = true)
data class DealResponse(
  @Json(name = "products")
  val deals: List<Deal>
)