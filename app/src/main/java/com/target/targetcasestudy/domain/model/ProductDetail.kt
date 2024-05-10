package com.target.targetcasestudy.domain.model

data class ProductDetail(val id: String,
                         val name: String,
                         val regularPrice: Price,
                         val salePrice: Price,
                         val imgUrl: String,
                         val fulfillment: String, )