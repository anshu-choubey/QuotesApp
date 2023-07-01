package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotesapp.screens.QuotesDetail
import com.example.quotesapp.screens.QuotesListScreen
import com.example.quotesapp.ui.theme.QuotesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            DataManager.loadAssetFromFile(applicationContext)
        }
        setContent {
            QuotesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value){
        if (DataManager.currentPage.value == Pages.LISTING){

            QuotesListScreen(data = DataManager.data) {
                DataManager.switchPages(it)

            }
        }
        else{
            DataManager.currentQuote?.let { QuotesDetail(quotes = it) }
        }
    }else{
        Box(contentAlignment = Alignment.Center, 
            modifier = Modifier.fillMaxSize(1f)) {
            Text(text = "Loading", style = MaterialTheme.typography.headlineMedium)

        }
    }
    
}

enum class Pages{
    LISTING,
    DETAIL
}