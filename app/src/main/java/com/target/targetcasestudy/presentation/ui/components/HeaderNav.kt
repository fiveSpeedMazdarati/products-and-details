package com.target.targetcasestudy.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.target.targetcasestudy.R

@Composable
fun HeaderNav(showBackArrow: Boolean, title: String, onClick: () -> Unit ) {
    Column () {Row (modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
        .padding(8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.back),
            modifier = Modifier
                .size(32.dp)
                .padding(6.dp)
                .align(Alignment.CenterVertically),
            contentDescription = stringResource(R.string.back_arrow)
        )
        Text(
            text = title,
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
            fontSize = 4.em,
            fontWeight = FontWeight.W700
        )
    }
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
    }
}

@Preview
@Composable
fun HeaderNavPreview() {
    HeaderNav(showBackArrow = true, title = "Details") {
        // navigate to somewhere
    }
}