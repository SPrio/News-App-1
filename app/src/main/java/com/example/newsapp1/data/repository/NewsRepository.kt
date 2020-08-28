package com.example.newsapp1.data.repository

import com.example.newsapp1.data.network.NewsApi
import com.example.newsapp1.data.network.SafeApiRequest

class NewsRepository(
    private val api: NewsApi
) : SafeApiRequest() {

    suspend fun getNews() = apiRequest {
        val data: MutableMap<String, String> = HashMap()
        data["country"] = "in"
        data["apiKey"] = "621b8f6369f345978059ce9f3739a13c"
        api.getNews(data)
    }

}
