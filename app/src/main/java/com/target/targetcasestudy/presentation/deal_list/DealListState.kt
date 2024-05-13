package com.target.targetcasestudy.presentation.deal_list

import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Deals

data class DealListState(
    val isLoading: Boolean = false,
    val deals: List<Deal> = listOf(),
    val error: String = ""

) {
}