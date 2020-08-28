package com.example.newsapp1.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp1.R
import com.example.newsapp1.data.models.News
import com.example.newsapp1.databinding.NewsItemBinding

class NewsAdapter(
    private val news: List<News>,
    private val context: Context

) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun getItemCount() = news.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.news_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.newsItemBinding.news = news[position]
        holder.newsItemBinding.headline.setOnClickListener {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra("headline", news[position].title)
            intent.putExtra("description", news[position].description)
            intent.putExtra("image", news[position].urlToImage)
            context.startActivity(intent)
        }
    }

    inner class NewsViewHolder(
        val newsItemBinding: NewsItemBinding
    ) : RecyclerView.ViewHolder(newsItemBinding.root)
}
