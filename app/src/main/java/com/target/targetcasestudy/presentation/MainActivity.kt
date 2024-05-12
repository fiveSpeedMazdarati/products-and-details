package com.target.targetcasestudy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.target.targetcasestudy.presentation.ui.components.DealListItem
import com.target.targetcasestudy.presentation.view.DealsListScreen
import com.target.targetcasestudy.presentation.viewmodel.DealsListViewModel

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {
    private val viewModel: DealsListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
                    DealsListScreen(viewModel = viewModel)
                }
            }
        }

    }
}
