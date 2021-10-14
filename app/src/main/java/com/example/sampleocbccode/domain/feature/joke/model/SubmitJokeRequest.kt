package com.example.sampleocbccode.domain.feature.joke.model

import com.google.gson.annotations.SerializedName

data class SubmitJokeRequest(
    @SerializedName("formatVersion") val formatVersion: Int,
    @SerializedName("category") val category: String,
    @SerializedName("type") val type: String,
    @SerializedName("joke") val joke: String,
    @SerializedName("flags") val flags: JokeFlag,
    @SerializedName("lang") val lang: String
)

data class JokeFlag(
    @SerializedName("nsfw") val nsfw: Boolean,
    @SerializedName("religious") val religious: Boolean,
    @SerializedName("political") val political: Boolean,
    @SerializedName("racist") val racist: Boolean,
    @SerializedName("sexist") val sexist: Boolean,
    @SerializedName("explicit") val explicit: Boolean
)


