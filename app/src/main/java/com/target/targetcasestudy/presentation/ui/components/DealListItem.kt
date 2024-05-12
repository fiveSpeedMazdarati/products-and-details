package com.target.targetcasestudy.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Price

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
        GlideImage(model = deal.imageUrl,
            contentDescription = deal.title,
            modifier = Modifier.clip(RoundedCornerShape(10.dp)).fillMaxWidth(.4f))

        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                if (deal.salePrice != null) {
                        Text(text = deal.salePrice.displayString)
                        Text(text = " reg. ")
                    }
                Text(text = deal.regularPrice.displayString)
            }

            Text(text = deal.fulfillment)
            Text(text = deal.title)
            Row {
                Text(text = deal.availability)
                Text(text = " in aisle ${deal.aisle.toUpperCase(Locale("en"))}")
            }
            
        }
    }
}
@Preview(widthDp = 360, heightDp = 174)
@Composable
fun Preview() {
    DealListItem(deal = Deal(
        id = 1,
        title = "Big Green Thing",
        aisle ="a10",
        regularPrice = Price(amountInCents = 1499, currencySymbol = "$", displayString = "$14.99"),
        salePrice = Price(amountInCents = 17699, currencySymbol = "$", displayString = "$12.99"),
        fulfillment = "Online",
        imageUrl = "https://appstorage.target.com/app-data/native-tha-images/3.jpg",
        availability = "In stock",
        description = "This is a very large thing, in the color green. Other colors available."),
        onItemClick = { // do nothing for now
        }
    )
}



