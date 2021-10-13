package com.example.sampleocbccode.model

data class GetJokesResponse(
    val error: Boolean,
    val amount: Int,
    val jokes: List<Joke>
)