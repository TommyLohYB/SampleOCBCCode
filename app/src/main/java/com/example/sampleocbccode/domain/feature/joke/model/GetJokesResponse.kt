package com.example.sampleocbccode.domain.feature.joke.model

data class GetJokesResponse(
    val error: Boolean,
    val amount: Int,
    val jokes: List<Joke>
)

data class Joke(
    val category: String,
    val type: String,
    val setup: String,
    val delivery: String,
)