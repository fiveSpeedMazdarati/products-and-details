package com.target.targetcasestudy.data

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
    val salePrice: PriceDto,
    val title: String
)

/*
*   In this case mapping the responses from the api to the domain objects is a bit of overkill since the data set is small.
*   However, in a larger JSON response it would be advantageous to make the display object smaller and easier to work with,
*   as well as take up less memory.
*
*   This mapping also has the effect of translating the nomenclature from "deal" as the API is called,
*   to "product" which is the information that is actually returned and used in the app.
 */
fun DealDto.toProduct() : Deal {
    return Deal(
        aisle = aisle,
        availability = availability,
        fulfillment = fulfillment,
        id = id,
        imageUrl = imageUrl,
        regularPrice = regularPrice.toPrice(),
        salePrice = salePrice.toPrice(),
        title = title
    )
}
