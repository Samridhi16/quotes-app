package com.sam.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sam.quotesapp.models.Quote

@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (quote: Quote)-> Unit) {
    Column() {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(0.dp,50.dp,0.dp,20.dp)
                .fillMaxWidth(1f),
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily.Monospace
        )
        QuoteList(data = data, onClick)
    }
}