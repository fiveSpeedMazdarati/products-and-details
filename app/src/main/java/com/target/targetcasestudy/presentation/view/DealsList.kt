package com.target.targetcasestudy.presentation.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.target.targetcasestudy.presentation.viewmodel.DealsListViewModel

@Composable
fun DealsListScreen(viewModel: DealsListViewModel) {
    val state = viewModel.state
    LazyColumn (

    ) {

    }
}
