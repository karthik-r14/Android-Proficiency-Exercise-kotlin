package com.android_proficiency_exercise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.android_proficiency_exercise.R
import com.android_proficiency_exercise.model.NewsItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

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
        val imageUrlString = newsItems.get(position).imageUrl

        var imageUrl: String? = null

        if (imageUrlString != "") {
//            imageUrl = imageUrlString?.replace("http", "https")
            imageUrl = imageUrlString?.toUri()?.buildUpon()?.scheme("https")?.build().toString()
        }

        Glide.with(context)
            .load(imageUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_image)
                    .error(R.drawable.error_image)
            )
            .into(holder.newsItemImageView)
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