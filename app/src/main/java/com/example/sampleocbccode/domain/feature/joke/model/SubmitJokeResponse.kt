package com.example.sampleocbccode.domain.feature.joke.model

data class SubmitJokeResponse(
    val error: Boolean,
    val message: String,
    val additionalInfo: String
)