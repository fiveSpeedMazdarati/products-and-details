package com.target.targetcasestudy.data.remote

import com.target.targetcasestudy.api.Price

data class Deal(
  val id: String,

  val title: String,

  val aisle: String,

  val description: String,

  val salePrice: Price
)