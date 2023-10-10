package com.example.kotlin.examv2.data.network.model

import com.google.gson.annotations.SerializedName

data class movieObject (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: ArrayList<com.example.kotlin.examv2.data.network.model.movieBase>,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("total_results") val total_results: Int
)