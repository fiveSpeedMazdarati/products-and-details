package com.target.targetcasestudy.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.target.targetcasestudy.common.Resource
import com.target.targetcasestudy.domain.use_case.GetDealsUseCase
import com.target.targetcasestudy.presentation.view.DealListState
import dagger.hilt.android.lifecycle.HiltViewModel
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
                    Log.i("new data!", it.data?.products.toString())
                }
                is Resource.Loading -> {
                    Log.i("loading", "LOADING SPINNER SHOWING")
                }
                is Resource.Error -> {
                    Log.e("ERROR", it.message.toString())
                }
            }
        }
    }

}