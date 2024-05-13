package com.target.targetcasestudy.presentation.deal_details

import com.target.targetcasestudy.domain.model.Deal

data class DealDetailState (val deal: Deal? = null,
                            val isLoading: Boolean = false,
                            val errorMessage: String = "") {

}
