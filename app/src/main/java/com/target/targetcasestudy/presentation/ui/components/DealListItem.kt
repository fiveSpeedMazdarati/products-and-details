package com.target.targetcasestudy.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.createSavedStateHandle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.target.targetcasestudy.R
import com.target.targetcasestudy.common.Constants
import com.target.targetcasestudy.domain.model.Deal
import com.target.targetcasestudy.domain.model.Price

/**
 * A composable representing a deal item overview
 *
 * @param deal The deal to display
 * @param onItemClick The action to take when the deal is clicked
 */
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DealListItem(
    deal: Deal,
    onItemClick: (Deal) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clickable {
                    onItemClick(deal)
                }
                .padding(20.dp),

            ) {
            GlideImage(
                model = deal.imageUrl,
                contentDescription = deal.title,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth(.4f)
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Row {
                    // this handles the situation where there is no sale price available

                    // in this case, there is a sale price available
                    if (deal.salePrice != null) {
                        Text(
                            text = deal.salePrice.displayString,
                            color = Color(
                                ContextCompat.getColor(
                                    LocalContext.current,
                                    R.color.colorPrimaryDark
                                )
                            ),
                            fontWeight = FontWeight.W700,
                            fontSize = 21.sp,
                            modifier = Modifier.align(Alignment.Bottom)
                        )

                        Text(
                            text = "reg. " + deal.regularPrice.displayString,
                            color = Color(
                                ContextCompat.getColor(
                                    LocalContext.current,
                                    R.color.darker_gray_color
                                )
                            ),
                            fontWeight = W400,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .align(Alignment.Bottom)
                                .padding(start = 8.dp, bottom = 2.dp)
                        )
                    } else {
                        // there is no sale price available, so make the regular price larger and bold
                        Text(text = deal.regularPrice.displayString,
                            fontWeight = W700,
                            fontSize = 21.sp)
                    }

                }

                Text(
                    text = deal.fulfillment,
                    fontSize = 12.sp,
                    color = Color(
                        ContextCompat.getColor(
                            LocalContext.current,
                            R.color.gray_color
                        )
                    ),
                    modifier = Modifier.padding(top = 2.dp)
                )

                Text(
                    text = deal.title,
                    fontSize = 14.sp,
                    fontWeight = W400,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    Text(
                        text = deal.availability,
                        fontSize = 12.sp,
                        color = Color(
                            ContextCompat.getColor(
                                LocalContext.current,
                                R.color.colorAccent
                            )
                        )
                    )
                    Text(
                        text = " in aisle ${deal.aisle.toUpperCase(Locale("en"))}",
                        fontSize = 12.sp,
                        color = Color(
                            ContextCompat.getColor(
                                LocalContext.current,
                                R.color.gray_color
                            )
                        )
                    )
                }

            }

        }
        HorizontalDivider(modifier = Modifier
            .height(height = 0.5.dp)
            .padding(start = 20.dp))
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
        salePrice =  null/*Price(amountInCents = 17699, currencySymbol = "$", displayString = "$12.99") */,
        fulfillment = "Online",
        imageUrl = "https://appstorage.target.com/app-data/native-tha-images/3.jpg",
        availability = "In stock",
        description = "This is a very large thing, in the color green. Other colors available."),
        onItemClick = { // do nothing for now
        }
    )
}



