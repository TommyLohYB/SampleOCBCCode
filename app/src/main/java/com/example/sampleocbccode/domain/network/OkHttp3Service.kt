package com.example.sampleocbccode.domain.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttp3Service {

    private fun okhttpService():OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    val okHttpClient: OkHttpClient by lazy { okhttpService() }

}