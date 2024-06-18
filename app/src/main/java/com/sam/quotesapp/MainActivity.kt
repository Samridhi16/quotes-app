package com.sam.quotesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sam.quotesapp.screens.QuoteDetail
import com.sam.quotesapp.screens.QuoteList
import com.sam.quotesapp.screens.QuoteListScreen
import com.sam.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //to improve performance, running a UI thread
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
           App()
        }
    }
}

@Composable
fun App(){
    //when flag is true then we show the list
    if(DataManager.isDataLoaded.value){

        if(DataManager.currentPage.value == Pages.LISTING){
            //event will occur in the lowest composable but will be handled at the top
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }
    }else{
        //if fetching from Api , show loading
        Box(
            modifier = Modifier.fillMaxWidth(1f),
            contentAlignment = Alignment.Center){
            Text(text = "Loading...",
                style = MaterialTheme.typography.bodyMedium)
        }
    }
}

enum class Pages{
    LISTING,
    DETAIL
}