package com.target.targetcasestudy.data

import com.target.targetcasestudy.domain.model.Deals

/**
 * A class representing the response from the Deal API - all the current deals available
 */
data class DealsDto(
    val products: List<DealDto>
)
/*
*   In this case mapping the responses from the api to the domain objects is a bit of overkill since the data set is small.
*   However, in a larger JSON response it would be advantageous to make the display object smaller and easier to work with,
*   as well as take up less memory.
*
*   This mapping also has the effect of translating the nomenclature from "deals" as the API is called,
*   to "products" which is the information that is actually returned and used in the app.
 */
fun DealsDto.toProducts() : Deals {
    return Deals(products = products.map { it.toProduct() })
}