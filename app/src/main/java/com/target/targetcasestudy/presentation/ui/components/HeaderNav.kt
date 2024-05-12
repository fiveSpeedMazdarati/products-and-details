package com.target.targetcasestudy.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.target.targetcasestudy.R

@Composable
fun HeaderNav(showBackArrow: Boolean, title: String ) {
    Row {
       Image(painter = painterResource(id = R.drawable.back), contentDescription = stringResource(R.string.back_arrow))
       Text(text = title) 
    }
}

@Preview
@Composable
fun HeaderNavPreview() {
    HeaderNav(showBackArrow = true, title = "Back")
}