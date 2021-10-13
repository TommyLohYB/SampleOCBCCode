package com.example.sampleocbccode.api

import com.example.sampleocbccode.model.GetJokesResponse

import retrofit2.Response
import retrofit2.http.GET

interface JokesAPI {

    @GET("Programming?amount=2&type=single")
    suspend fun getJokes(): Response<GetJokesResponse>
}