package com.example.sampleocbccode.domain.feature.joke.repository

import com.example.sampleocbccode.domain.feature.joke.model.Joke
import com.example.sampleocbccode.domain.feature.joke.model.SubmitJokeRequest
import com.example.sampleocbccode.domain.feature.joke.service.JokesAPI
import com.example.sampleocbccode.domain.network.RetrofitService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class JokeRepository @Inject constructor(private val jokesAPI: JokesAPI) {

    suspend fun getJoke(): MutableList<Joke> {
        var jokes: MutableList<Joke> = mutableListOf()
        val getJokeResponse = jokesAPI.getJokes()
        if (getJokeResponse.isSuccessful) {
            jokes = (getJokeResponse.body()?.jokes ?: mutableListOf<Joke>()) as MutableList<Joke>
        }
        return jokes
    }

    suspend fun submitJoke(submitJokeRequest: SubmitJokeRequest): String {
        val submitJokeResponse = jokesAPI.submitJoke(submitJokeRequest)
        if (submitJokeResponse.isSuccessful) {
            return submitJokeResponse.body()?.message ?: "error"
        }
        return "error"
    }
}
