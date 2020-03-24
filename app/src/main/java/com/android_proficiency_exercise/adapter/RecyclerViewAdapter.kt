package com.android_proficiency_exercise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android_proficiency_exercise.R
import com.android_proficiency_exercise.model.NewsItem

class RecyclerViewAdapter(
    newsItems: List<NewsItem>,
    context: Context
) :
    RecyclerView.Adapter<RecyclerViewAdapter.NewsViewHolder>() {

    var newsItems: List<NewsItem>
    var context: Context

    init {
        this.newsItems = newsItems
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.newsItemTitle.setText(newsItems.get(position).title)
        holder.newsItemDescription.setText(newsItems.get(position).description)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var newsItemTitle: TextView
        var newsItemDescription: TextView
        var newsItemImageView: ImageView

        init {
            newsItemTitle = itemView.findViewById(R.id.news_item_title)
            newsItemDescription = itemView.findViewById(R.id.news_item_description)
            newsItemImageView = itemView.findViewById(R.id.news_item_image)
        }
    }
}