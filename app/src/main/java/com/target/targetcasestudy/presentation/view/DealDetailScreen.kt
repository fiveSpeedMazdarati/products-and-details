package com.target.targetcasestudy.presentation.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.target.targetcasestudy.R
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Price
import com.target.targetcasestudy.presentation.ui.components.DealDetailContent
import com.target.targetcasestudy.presentation.ui.components.FooterButton
import com.target.targetcasestudy.presentation.ui.components.HeaderNav

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DealDetailScreen (deal: Deal) {

    Scaffold(topBar = {
        HeaderNav(
            showBackArrow = true,
            title = "Detail",
            onClick = {})
            },
        bottomBar = {
            FooterButton(
                text = stringResource(R.string.add_to_cart_button_call_to_action)) {
                    // on click doesn't do anything yet
                }
        }
    ) {
        //it.calculateTopPadding()

        Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
            DealDetailContent(deal = deal)
        }
    }
}

@Preview
@Composable
fun DealDetailScreenPreview() {
    DealDetailScreen(deal = Deal(
        id = 1,
        title = "Big Green Thing",
        aisle = "a10",
        regularPrice = Price(
            amountInCents = 1499,
            currencySymbol = "$",
            displayString = "$14.99"
        ),
        salePrice = Price(
            amountInCents = 17699,
            currencySymbol = "$",
            displayString = "$12.99"
        ),
        fulfillment = "Online",
        imageUrl = "https://appstorage.target.com/app-data/native-tha-images/3.jpg",
        availability = "In stock",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Aliquam sed lacus vitae risus convallis cursus. Suspendisse lorem orci, " +
                "condimentum venenatis arcu nec, placerat mattis diam. In facilisis, nulla sit amet luctus lobortis, " +
                "purus justo lobortis odio, sed vestibulum turpis odio in enim. Proin fringilla mattis nisi vel pretium. " +
                "Curabitur eu egestas turpis, iaculis ultricies lorem. Proin nec orci bibendum, efficitur ligula eget, " +
                "rutrum ipsum. Pellentesque efficitur nulla nec condimentum consectetur. " +
                "Praesent tempus, risus quis consectetur laoreet, orci metus gravida quam, " +
                "quis venenatis nisl tellus ac augue"
    ))
}