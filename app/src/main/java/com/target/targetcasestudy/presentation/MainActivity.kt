package com.target.targetcasestudy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.target.targetcasestudy.presentation.deal_list.DealsListScreen
import com.target.targetcasestudy.presentation.deal_list.DealsListViewModel
import androidx.navigation.compose.rememberNavController
import com.target.targetcasestudy.common.Screen
import com.target.targetcasestudy.presentation.deal_details.DealDetailScreen

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.DealListScreen.route
                    ) {
                        composable(
                            route = Screen.DealListScreen.route
                        ) {
                            DealsListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.DealDetailScreen.route + "/{deal_id}"
                        ) {
                            DealDetailScreen(navController = navController)
                        }
                    }

                }

            }
        }
    }

}

