package com.example.newsapp1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp1.data.repository.NewsRepository

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory(
    private val repository: NewsRepository
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }

}
