package com.target.targetcasestudy.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.target.targetcasestudy.R
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Price
import kotlinx.coroutines.FlowPreview

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DealListItem(
    deal: Deal,
    onItemClick: (Deal) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(deal)
            }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        GlideImage(model = deal.imageUrl, contentDescription = deal.title)
    }
}
@Preview(widthDp = 300, heightDp = 80)
@Composable
fun Preview() {
    DealListItem(deal = Deal(
        id = 1,
        title = "Big Green Thing",
        aisle ="W10",
        regularPrice = Price(amountInCents = 1499, currencySymbol = "$", displayString = "$14,99"),
        salePrice = Price(amountInCents = 17699, currencySymbol = "$", displayString = "Larger Green Thing"),
        fulfillment = "In Stock",
        imageUrl = "",
        availability = "Online and In-Store"),
        onItemClick = { // do nothing for now
        }
    )
}



