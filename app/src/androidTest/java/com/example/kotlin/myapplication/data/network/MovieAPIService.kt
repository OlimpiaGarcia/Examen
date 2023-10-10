package com.example.kotlin.myapplication.data.network

import com.example.kotlin.myapplication.data.network.model.movie.Movie
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPIService {

    // https://api.themoviedb.org/3/movie/popular?limit=1279
    @GET("Movie")
    suspend fun getMovieList(
        @Query("limit") limit:Int
    ): com.example.kotlin.myapplication.data.network.model.MovieObject

    // https://api.themoviedb.org/3/movie/popular{number_movie}/
    @GET("movie/{numberMovie}")
    suspend fun getMovieInfo(
        @Path("numberMovie") numberMovie:Int
    ): Movie
}