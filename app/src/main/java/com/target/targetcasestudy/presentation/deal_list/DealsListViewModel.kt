package com.target.targetcasestudy.presentation.deal_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.domain.use_case.GetDealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class DealsListViewModel @Inject constructor(private val getDealsUseCase: GetDealsUseCase) : ViewModel() {

    private val _state = mutableStateOf(DealListState())
    val state: State<DealListState> = _state

    init {
        getAllDeals()
    }
    fun getAllDeals() {
        getDealsUseCase().onEach {
            when(it) {
                is Resource.Success -> {
                    _state.value = DealListState(
                        isLoading = false,
                        deals = it.data?.products ?: emptyList(),
                        error = "")

                }
                is Resource.Loading -> {
                    _state.value = DealListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = DealListState(
                        isLoading = false,
                        deals = it.data?.products ?: emptyList(),
                        error = "There was a problem retrieving the deals." )

                }
            }
        }.launchIn(viewModelScope)
    }

}