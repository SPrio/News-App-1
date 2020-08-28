package com.example.newsapp1.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp1.data.models.News
import com.example.newsapp1.data.repository.NewsRepository
import com.example.newsapp1.util.Coroutines
import kotlinx.coroutines.Job

class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>>
        get() = _news

    fun getNews() {
        job = Coroutines.ioThenMain(
            { repository.getNews() },
            { _news.value = it!!.articles }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

    var headline: String = ""
    var description: String = ""
    var image: String = ""
}
