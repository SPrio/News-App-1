package com.example.newsapp1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp1.R
import com.example.newsapp1.data.network.NewsApi
import com.example.newsapp1.data.repository.NewsRepository
import com.example.newsapp1.databinding.ActivityNewsDetailsBinding

class NewsDetailsActivity : AppCompatActivity() {
    private lateinit var factory: NewsViewModelFactory
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val headline = intent.extras!!.getString("headline")
        val description = intent.extras!!.getString("description")
        val image = intent.extras!!.getString("image")
        val api = NewsApi()
        val repository = NewsRepository(api)

        factory = NewsViewModelFactory(repository)
        val binding: ActivityNewsDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_details)
        viewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.headline = headline!!
        viewModel.description = description!!
        viewModel.image = image!!
    }
}
