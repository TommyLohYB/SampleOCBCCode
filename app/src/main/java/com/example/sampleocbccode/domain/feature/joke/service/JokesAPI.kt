package com.example.sampleocbccode.domain.feature.joke.service

import com.example.sampleocbccode.domain.feature.joke.model.GetJokesResponse
import com.example.sampleocbccode.domain.feature.joke.model.SubmitJokeRequest
import com.example.sampleocbccode.domain.feature.joke.model.SubmitJokeResponse

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface JokesAPI {

    @GET("joke/Programming?amount=10&type=twopart")
    suspend fun getJokes(): Response<GetJokesResponse>

    @Headers("Content-Type: application/json")
    @POST("submit")
    suspend fun submitJoke(@Body submitJokeRequest: SubmitJokeRequest): Response<SubmitJokeResponse>
}