package com.target.targetcasestudy.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.target.targetcasestudy.domain.model.Deal

/**
 * A class representing an individual deal that is returned from the deals API
 */
data class DealDto(
    val aisle: String,
    val availability: String,
    val description: String,
    val fulfillment: String,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("regular_price")
    val regularPrice: PriceDto,
    @SerializedName("sale_price")
    val salePrice: PriceDto?,
    val title: String
)

/*
*   In this case mapping the responses from the api to the domain objects is a bit of overkill since the data set is small.
*   However, in a larger JSON response it would be advantageous to make the display object smaller and easier to work with,
*   as well as take up less memory.
 */
fun DealDto.toDeal() : Deal {
    return Deal(
        aisle = aisle,
        availability = availability,
        fulfillment = fulfillment,
        id = id,
        imageUrl = imageUrl,
        regularPrice = regularPrice.toPrice(),
        salePrice = salePrice?.let { it.toPrice() },
        title = title,
        description = description
    )
}
