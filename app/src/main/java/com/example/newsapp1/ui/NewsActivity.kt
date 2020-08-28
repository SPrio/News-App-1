package com.example.newsapp1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp1.R
import com.example.newsapp1.data.network.NewsApi
import com.example.newsapp1.data.repository.NewsRepository
import com.example.newsapp1.databinding.ActivityNewsBinding
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {
    private lateinit var factory: NewsViewModelFactory
    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = NewsApi()
        val repository = NewsRepository(api)

        factory = NewsViewModelFactory(repository)
        val binding: ActivityNewsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news)
        viewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.getNews().also {
            viewModel.news.observe(this as LifecycleOwner, Observer { news ->
                recycler_view_news.also {
                    it.layoutManager = LinearLayoutManager(this)
                    it.setHasFixedSize(true)
                    it.adapter = NewsAdapter(news, this)
                }
            })
        }
    }
}
