package com.example.sampleocbccode.domain.feature.joke.model

data class Joke(
    val category: String,
    val type: String,
    val setup: String,
    val delivery: String,
)