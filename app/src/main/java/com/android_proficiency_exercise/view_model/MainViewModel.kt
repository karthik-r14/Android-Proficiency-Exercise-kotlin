package com.android_proficiency_exercise.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android_proficiency_exercise.model.NewsItem

class MainViewModel : ViewModel() {
    val newsItems = MutableLiveData<ArrayList<NewsItem>>()

    init {
        Log.d(MainViewModel::class.simpleName, "Main view model is created")
        newsItems.value = ArrayList()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(MainViewModel::class.simpleName, "Main view model is destroyed")
    }

    fun setNewsItems(newsItems: java.util.ArrayList<NewsItem>) {
        this.newsItems.value = newsItems
    }
}