package com.target.targetcasestudy.presentation.deal_details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.target.targetcasestudy.R

@Composable
fun FooterButton(text: String, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color.White)
            .height(75.dp)
            .shadow(1.dp)

    ) {

        TextButton(onClick = onClick, modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                Color(
                    ContextCompat.getColor(LocalContext.current, R.color.red_color)
                )
            )) {
            Text(text = text, color = Color.White, textAlign = TextAlign.Center, fontSize = 18.sp, fontWeight = W700)
        }
    }

}

@Preview
@Composable
fun FooterButtonPreview() {
    FooterButton(text = stringResource(id = R.string.add_to_cart_button_call_to_action)) {
        // nothing on click just yet
    }
}