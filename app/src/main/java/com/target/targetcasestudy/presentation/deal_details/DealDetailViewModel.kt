package com.target.targetcasestudy.presentation.deal_details

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.target.targetcasestudy.domain.use_case.GetDealUseCase
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.common.Resource
import kotlinx.coroutines.flow.launchIn
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

    fun getDealDetails(dealId: String) {
        getDealDetailUseCase(dealId).onEach {
            when (it) {
                is Resource.Loading -> _state.value =
                    DealDetailState(
                        deal = null,
                        isLoading = true,
                        errorMessage = ""
                    )
                is Resource.Success -> _state.value =
                    DealDetailState(
                        deal = it.data,
                        isLoading = false,
                        errorMessage = ""
                    )
                is Resource.Error -> _state.value =
                    DealDetailState(
                        deal = null,
                        isLoading = false,
                        errorMessage = it.message ?: "Could not get deal details")
            }
        }.launchIn(viewModelScope)
    }
}