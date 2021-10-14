package com.example.sampleocbccode.domain.feature.joke.model

data class GetJokesResponse(
    val error: Boolean,
    val amount: Int,
    val jokes: List<Joke>
)