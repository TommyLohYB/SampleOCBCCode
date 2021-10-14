package com.example.sampleocbccode.domain.feature.joke.repository

import android.util.Log
import com.example.sampleocbccode.domain.feature.joke.model.Joke
import com.example.sampleocbccode.domain.feature.joke.model.SubmitJokeRequest
import com.example.sampleocbccode.domain.network.RetrofitService
import kotlinx.coroutines.*

class JokeRepository {

    suspend fun getJoke(): MutableList<Joke> {
        var jokes: MutableList<Joke> = mutableListOf()
        val getJokeResponse = RetrofitService.jokeApi.getJokes()
        if (getJokeResponse.isSuccessful) {
            jokes = (getJokeResponse.body()?.jokes ?: mutableListOf<Joke>()) as MutableList<Joke>
        }
        return jokes
    }

    suspend fun submitJoke(submitJokeRequest: SubmitJokeRequest): String {
        val submitJokeResponse = RetrofitService.jokeApi.submitJoke(submitJokeRequest)
        if (submitJokeResponse.isSuccessful) {
            return submitJokeResponse.body()?.message ?: "error"
        }
        return "error"
    }
}