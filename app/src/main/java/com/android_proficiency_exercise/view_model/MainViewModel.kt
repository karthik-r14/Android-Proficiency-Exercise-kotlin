package com.android_proficiency_exercise.view_model

import android.content.Context
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android_proficiency_exercise.R
import com.android_proficiency_exercise.model.NewsItem
import com.android_proficiency_exercise.model.NewsItemResponse
import com.android_proficiency_exercise.rest.NewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    val newsItems = MutableLiveData<ArrayList<NewsItem>>()
    val actionBarTitle = MutableLiveData<String>()

    init {
        Log.d(MainViewModel::class.simpleName, "Main view model is created")
        newsItems.value = ArrayList()
        actionBarTitle.value = "Android-Proficiency-Exercise"
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(MainViewModel::class.simpleName, "Main view model is destroyed")
    }

//    fun setNewsItems(newsItems: java.util.ArrayList<NewsItem>) {
//        this.newsItems.value = newsItems
//    }

    fun getNewsItemsFromServer(context: Context) {
        NewsApi.retrofitService.getNewsItems().enqueue(object : Callback<NewsItemResponse> {
            override fun onFailure(call: Call<NewsItemResponse>, t: Throwable) {
                Toast.makeText(context, context.getString(R.string.failure_to_load_data_msg) + t.message.toString(), LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<NewsItemResponse>,
                response: Response<NewsItemResponse>
            ) {
                newsItems.value = response.body()?.newsItems as ArrayList<NewsItem>?
                actionBarTitle.value = response.body()?.title
            }
        })
    }
}