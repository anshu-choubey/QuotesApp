package com.example.quotesapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.models.Quotes

@Composable
fun QuotesListItem(quotes: Quotes, onClick: (quotes: Quotes)->Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp,8.dp,8.dp,8.dp).clickable { onClick(quotes) },
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()) {
            Image(imageVector = Icons.Filled.FormatQuote,
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .rotate(180f)
                    .background(Color.Black)
                    .align(Alignment.CenterVertically))
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()) {
                Text(text = quotes.quote, modifier = Modifier
                    .padding(3.dp,3.dp,3.dp,3.dp),
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold)
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth(1f)
                    .height(1.dp)) {}
                Text(text = quotes.author, fontSize = 12.sp, modifier = Modifier
                    .padding(3.dp,3.dp,3.dp,3.dp))

            }
        }

    }

}