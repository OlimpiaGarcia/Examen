package com.example.kotlin.examv2.data.network

import com.example.kotlin.examv2.data.network.model.movie.Movies
import com.example.kotlin.examv2.data.network.model.movieObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface movieAPIService {
    // https://api.themoviedb.org/3/movie/popular/
    @GET("movie/popular")
    suspend fun getList(
        @Header("Authorization") apiKey: String,
        @Query("limit") limit: Int
    ): movieObject

    // https://api.themoviedb.org/3/movie/{movie_id}
    @GET("movie/{movieId}")
    suspend fun getInfo(
        @Path("movieId") movieId: Int
    ): Movies
}