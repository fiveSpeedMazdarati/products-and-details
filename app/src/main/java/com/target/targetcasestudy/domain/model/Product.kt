package com.target.targetcasestudy.domain.model

data class Product(
    val id: Int,
    val title: String,
    val aisle: String,
    val regularPrice: Price,
    val salePrice: Price,
    val fulfillment: String,
    val imageUrl: String,
    val availability: String
)