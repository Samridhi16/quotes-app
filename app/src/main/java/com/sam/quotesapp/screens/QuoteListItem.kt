package com.sam.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sam.quotesapp.R
import com.sam.quotesapp.models.Quote


@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote)->Unit ) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(8.dp)
    ){
        Row (
            modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp)
        ){
            Image(painter = painterResource(id = R.drawable.formatquote),
                contentDescription = "Quote",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(50.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp,0.dp,0.dp,0.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp)
                )
//                Divider()
                Box(modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth(.4f)
                    .height(1.dp)
                )

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}
