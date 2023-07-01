package com.example.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.DataManager
import com.example.quotesapp.models.Quotes


@Composable
fun QuotesDetail(quotes: Quotes) {
    BackHandler() {
        DataManager.switchPages(null)

    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            ))
    {
        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
        ) {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp,24.dp)){
                Image(imageVector = Icons.Filled.FormatQuote,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .rotate(180f))
                Text(text = quotes.quote, modifier = Modifier
                    .padding(0.dp,0.dp,0.dp,2.dp),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold)

                Text(text = quotes.author, fontSize = 12.sp,
                    textAlign = TextAlign.End)


            }

        }
    }
}