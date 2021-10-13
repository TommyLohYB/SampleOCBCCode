package com.example.sampleocbccode.api

import com.example.sampleocbccode.model.GetJokesResponse
import com.example.sampleocbccode.model.SubmitJokeRequest
import com.example.sampleocbccode.model.SubmitJokeResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface JokesAPI {

    @GET("Programming?amount=2&type=single")
    suspend fun getJokes(): Response<GetJokesResponse>

    @Headers("Content-Type: application/json")
    @POST("submit")
    suspend fun submitJoke(@Body submitJokeRequest: SubmitJokeRequest): Response<SubmitJokeResponse>
}