package com.target.targetcasestudy.presentation.view

import com.target.targetcasestudy.domain.model.Deal

data class DealDetailState (val deal: Deal?,
                            val isLoading: Boolean = false,
                            val errorMessage: String = "") {

}
