package com.android_proficiency_exercise.activity

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android_proficiency_exercise.R
import com.android_proficiency_exercise.adapter.RecyclerViewAdapter
import com.android_proficiency_exercise.databinding.ActivityMainBinding
import com.android_proficiency_exercise.model.NewsItem
import com.android_proficiency_exercise.util.InternetUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newsItems: ArrayList<NewsItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.refreshButton.setOnClickListener {
            val internetUtil = InternetUtil(applicationContext)
            internetUtil.connectivityAvailable()

            if (internetUtil.isInternetConnectivity) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.internet_available_msg),
                    LENGTH_LONG
                ).show()
                populateRecyclerView()
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.internet_not_available_msg),
                    LENGTH_LONG
                ).show()
            }
        }
    }

    private fun populateRecyclerView() {
        loadNewsItemsList()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = RecyclerViewAdapter(newsItems, this)
    }

    private fun loadNewsItemsList() {
        newsItems = ArrayList()
        newsItems.add(NewsItem("Title 1", "Description1", "Image url1"))
        newsItems.add(NewsItem("Title 2", "Description2", "Image url2"))
        newsItems.add(NewsItem("Title 3", "Description3", "Image url3"))
    }
}