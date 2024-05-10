package com.target.targetcasestudy.data

import com.google.gson.annotations.SerializedName
import com.target.targetcasestudy.domain.model.Price

/**
 * A class representing a price returned from the deals API.
 * The 'sale price' and 'regular price' are formatted exactly the same, so having two classes with the exact same members seemed unnecessary.
 */
data class PriceDto(
    @SerializedName("amount_in_cents")
    val amountInCents: Int,
    @SerializedName("currency_symbol")
    val currencySymbol: String,
    @SerializedName("display_string")
    val displayString: String
)

fun PriceDto.toPrice() : Price {
    return Price(amountInCents = amountInCents,
        currencySymbol = currencySymbol,
        displayString = displayString)
}