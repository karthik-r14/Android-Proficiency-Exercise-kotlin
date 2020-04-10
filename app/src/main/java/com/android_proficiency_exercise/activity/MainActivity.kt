package com.android_proficiency_exercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_proficiency_exercise.R
import com.android_proficiency_exercise.adapter.RecyclerViewAdapter
import com.android_proficiency_exercise.databinding.ActivityMainBinding
import com.android_proficiency_exercise.model.NewsItem
import com.android_proficiency_exercise.util.InternetUtil
import com.android_proficiency_exercise.view_model.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //    private lateinit var newsItems: ArrayList<NewsItem>
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.refreshButton.setOnClickListener {
            val internetUtil = InternetUtil(applicationContext)
            internetUtil.connectivityAvailable()
            viewModel.onRefreshButtonClick(internetUtil.isInternetConnectivity, applicationContext)
        }

        viewModel.newsItems.observe(this, Observer { newsItems ->
            populateRecyclerView(newsItems)
        })

        viewModel.actionBarTitle.observe(this, Observer { actionBarTitle ->
            val actionBar = supportActionBar
            actionBar!!.title = actionBarTitle
        })
    }

    private fun populateRecyclerView(newsItems: ArrayList<NewsItem>) {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecyclerViewAdapter(newsItems, this)
    }
}