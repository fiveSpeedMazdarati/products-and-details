package com.target.targetcasestudy.presentation.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.target.targetcasestudy.presentation.view.DealDetailState
import com.target.targetcasestudy.domain.use_case.GetDealUseCase
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.common.Resource
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class DealDetailViewModel @Inject constructor(
    private val getDealDetailUseCase: GetDealUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _state = mutableStateOf(DealDetailState(deal = null))
    val state: State<DealDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.DEAL_ID)?.let {
            getDealDetails(it)
        }
    }

    private fun getDealDetails(dealId: String) {
        getDealDetailUseCase(dealId).onEach {
            when (it) {
                is Resource.Loading -> _state.value = DealDetailState(null, true, "")
                is Resource.Success -> _state.value = DealDetailState(deal = it.data)
                is Resource.Error -> _state.value = DealDetailState(deal = null, isLoading = false, it.message ?: "Could not get deal details")
            }
        }
    }
}