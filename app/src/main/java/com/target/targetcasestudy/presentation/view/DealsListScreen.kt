package com.target.targetcasestudy.presentation.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.target.targetcasestudy.R
import com.target.targetcasestudy.presentation.Screen
import com.target.targetcasestudy.presentation.ui.components.DealListItem
import com.target.targetcasestudy.presentation.viewmodel.DealsListViewModel

@Composable
fun DealsListScreen(viewModel: DealsListViewModel = hiltViewModel(), navController: NavController) {

    val state = viewModel.state.value
    Log.i("RETRIEVED DEALS", state.deals.toString())

    Column {

        Text(text = stringResource(R.string.list_header),
            modifier = Modifier.padding(12.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.W700)

        Box(modifier = Modifier.fillMaxSize()) {

            if (state.deals.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.deals) { dealItem ->
                        DealListItem(deal = dealItem,
                            onItemClick = {

                                navController.navigate(Screen.DealDetailScreen.route + "/${dealItem.id}")
                            })

                        }
                    }
                }

            if (state.error.isNotBlank()) {
                Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG).show()
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            if (state.deals.isEmpty()) {
                Text("No deals found",
                    modifier = Modifier.align(Alignment.Center) )
            }
            }
        }
    }

