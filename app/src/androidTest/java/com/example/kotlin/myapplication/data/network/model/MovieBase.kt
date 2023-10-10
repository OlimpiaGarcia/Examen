package com.example.kotlin.myapplication.data.network.model

import com.google.gson.annotations.SerializedName

data class MovieBase(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
