package com.target.targetcasestudy.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.target.targetcasestudy.R
import com.target.targetcasestudy.presentation.Screen
import com.target.targetcasestudy.presentation.ui.components.DealDetailContent
import com.target.targetcasestudy.presentation.ui.components.FooterButton
import com.target.targetcasestudy.presentation.ui.components.HeaderNav
import com.target.targetcasestudy.presentation.viewmodel.DealDetailViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DealDetailScreen (viewModel: DealDetailViewModel = hiltViewModel(), navController: NavController) {

    val state = viewModel.state.value

    Scaffold(topBar = {
        HeaderNav(
            showBackArrow = true,
            title = stringResource(id = R.string.details_header_title),
            onClick = {
                    navController.navigate(Screen.DealListScreen.route)
                }
            )
        },
        bottomBar = {
            FooterButton(
                text = stringResource(R.string.add_to_cart_button_call_to_action)) {
                    // on click doesn't do anything yet
                }
        }
    ) {
        Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
            state.deal?.let {
                DealDetailContent(deal = state.deal)
            }
        }
    }
}

@Preview
@Composable
fun DealDetailScreenPreview() {
    DealDetailScreen(viewModel = hiltViewModel(), navController = rememberNavController())
}