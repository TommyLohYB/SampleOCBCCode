package com.example.sampleocbccode.domain.network

import com.example.sampleocbccode.domain.feature.joke.service.JokesAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://v2.jokeapi.dev/"

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttp3Service.okHttpClient)
            .baseUrl(BASE_URL).build()
    }

    val jokeApi: JokesAPI by lazy {
        retrofitService().create(JokesAPI::class.java)
    }
}