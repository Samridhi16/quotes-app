package com.sam.quotesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sam.quotesapp.DataManager
import com.sam.quotesapp.R
import com.sam.quotesapp.models.Quote



@Composable
fun QuoteDetail(quote: Quote){
    //handling back button - effect handler
    BackHandler() {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ){
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .padding(4.dp)

        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp, 24.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.formatquote),
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(180f)
                        .padding(4.dp)
                        .align(Alignment.Start)
                )
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(
                            Alignment.Start
                        )
                        .padding(4.dp)
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .align(
                            Alignment.Start
                        )
                        .padding(4.dp)
                )
            }
        }
    }
}
