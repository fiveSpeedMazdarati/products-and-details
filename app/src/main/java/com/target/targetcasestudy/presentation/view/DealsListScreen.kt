package com.target.targetcasestudy.presentation.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.target.targetcasestudy.presentation.ui.components.DealListItem
import com.target.targetcasestudy.presentation.viewmodel.DealsListViewModel

@Composable
fun DealsListScreen(viewModel: DealsListViewModel) {

    val state = viewModel.state.value
    Log.i("RETRIEVED DEALS", state.deals.toString())

    Column {

        Text(text = "List", modifier = Modifier.padding(12.dp), fontSize = 18.sp, fontWeight = FontWeight.W700)

        Box(modifier = Modifier.fillMaxSize()) {

            if (state.error.isNotBlank()) {
                Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_LONG).show()
            }
            if (state.isLoading) {
                CircularProgressIndicator()
            }

            if (state.deals.isEmpty()) {
                Toast.makeText(LocalContext.current, "", Toast.LENGTH_LONG).show()
            }

            if (state.deals.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.deals) { dealItem ->
                        DealListItem(deal = dealItem) {

                        }
                    }
                }
            }
        }
    }

}
