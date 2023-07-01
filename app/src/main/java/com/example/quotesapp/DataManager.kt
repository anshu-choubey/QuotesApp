package com.example.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.models.Quotes
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quotes>()
    var currentPage = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)
    var currentQuote: Quotes? = null

    fun loadAssetFromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quotes>::class.java)
        isDataLoaded.value = true


    }

    fun switchPages(quotes: Quotes?){
        if (currentPage.value == Pages.LISTING){
            currentQuote = quotes
            currentPage.value = Pages.DETAIL}
        else currentPage.value = Pages.LISTING
    }
}