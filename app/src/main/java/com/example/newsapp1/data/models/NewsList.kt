package com.example.newsapp1.data.models

data class NewsList(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)
