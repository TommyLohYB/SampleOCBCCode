package com.example.sampleocbccode.domain.feature.joke.repository

import android.util.Log
import com.example.sampleocbccode.domain.feature.joke.model.Joke
import com.example.sampleocbccode.domain.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeRepository {

     fun getJoke(): List<Joke> {
        var jokes: List<Joke> = listOf()
        GlobalScope.launch(Dispatchers.IO) {
            jokes = getJokeFromApi()
        }
        return jokes
    }

    suspend fun getJokeFromApi () : List<Joke>{
        var jokes: List<Joke> = listOf()
        val getJokeResponse = RetrofitService.jokeApi.getJokes()
        if (getJokeResponse.isSuccessful) {
            jokes = getJokeResponse.body()?.jokes ?: listOf()
        }
        return jokes
    }
}
