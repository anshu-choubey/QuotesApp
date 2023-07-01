package com.example.quotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotesapp.models.Quotes

@Composable
fun QuotesList(data: Array<Quotes>,onClick: (quotes: Quotes)->Unit) {
    LazyColumn(content = {
        items(data) {
            QuotesListItem(quotes = it,onClick)

        }
    })
    
}

