package com.target.targetcasestudy.data

/**
 * A class representing the response from the Deal API - all the current deals available
 */
data class DealsDto(
    val products: List<DealDto>
)