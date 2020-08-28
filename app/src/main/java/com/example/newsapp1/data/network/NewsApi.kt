package com.example.newsapp1.data.network

import com.example.newsapp1.data.models.NewsList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNews(
        @QueryMap options: Map<String, String>
    ): Response<NewsList>

    companion object {
        operator fun invoke(): NewsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .build()
                .create(NewsApi::class.java)
        }
    }
}
