package com.target.targetcasestudy.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getColor
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.target.targetcasestudy.R
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Price

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DealDetailContent(deal: Deal) {
    Column {
        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Column(modifier = Modifier.align(Alignment.TopCenter)) {
                GlideImage(
                    model = deal.imageUrl,
                    contentDescription = deal.title,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.clip(
                        RoundedCornerShape(8.dp)
                    )
                )
                Text(
                    text = deal.title,
                    fontSize = 5.em,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(top = 12.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        text = deal.salePrice?.displayString ?: "No Price Available",
                        color = Color(getColor(LocalContext.current, R.color.colorPrimaryDark)),
                        fontWeight = W700,
                        fontSize = 21.sp,
                        modifier = Modifier.align(Alignment.Bottom)
                    )
                    Text(
                        text = "reg. ${deal.regularPrice.displayString}",
                        color = Color(getColor(LocalContext.current, R.color.darker_gray_color)),
                        fontWeight = FontWeight.W400,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.Bottom)
                    )
                }
                Text(
                    text = deal.fulfillment,
                    color = Color(getColor(LocalContext.current, R.color.gray_color)),
                    modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
                )

            }
        }

        HorizontalDivider()
        Spacer(modifier = Modifier.height(24.dp))
        HorizontalDivider()

        Box(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {

            Column() {

                Text(
                    text = stringResource(R.string.product_details_heading),
                    fontSize = 18.sp,
                    fontWeight = W700,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = deal.description,
                    lineHeight = 20.sp,
                    color = Color(getColor(LocalContext.current, R.color.gray_color)),
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )

            }
        }
        HorizontalDivider()
    }

}


@Preview
@Composable
fun DealDetailContentPreview() {
    DealDetailContent(
        deal = Deal(
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
        )
    )
}