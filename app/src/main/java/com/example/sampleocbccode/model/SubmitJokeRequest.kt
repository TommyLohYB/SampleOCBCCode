package com.example.sampleocbccode.model

import com.google.gson.annotations.SerializedName

data class SubmitJokeRequest(
    @SerializedName("formatVersion") val formatVersion: Int,
    @SerializedName("category") val category: String,
    @SerializedName("type") val type: String,
    @SerializedName("joke") val joke: String,
    @SerializedName("flags") val flags: JokeFlag,
    @SerializedName("lang") val lang: String
)


