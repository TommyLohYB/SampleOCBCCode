package com.example.sampleocbccode.domain.feature.joke.model

import com.google.gson.annotations.SerializedName

data class JokeFlag(
    @SerializedName("nsfw") val nsfw: Boolean,
    @SerializedName("religious") val religious: Boolean,
    @SerializedName("political") val political: Boolean,
    @SerializedName("racist") val racist: Boolean,
    @SerializedName("sexist") val sexist: Boolean,
    @SerializedName("explicit") val explicit: Boolean
)
