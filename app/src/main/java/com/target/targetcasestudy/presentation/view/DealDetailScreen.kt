package com.target.targetcasestudy.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Price
import com.target.targetcasestudy.presentation.ui.components.DealDetailContent
import com.target.targetcasestudy.presentation.ui.components.HeaderNav

@Composable
fun DealDetailScreen (deal: Deal) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column() {
            HeaderNav(showBackArrow = true, title = "Details") {
                // navigate back when clicked
            }
            DealDetailContent(deal = deal)
            // still need the Add to cart button here
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
        description = "This is a very large thing that happens to be in the color green. " +
                "Other colors available."
    ))
}