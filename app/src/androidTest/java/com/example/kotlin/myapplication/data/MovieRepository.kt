package com.example.kotlin.myapplication.data

import com.example.kotlin.myapplication.data.network.MovieApiClient


class MovieRepository() {
    private val apiMovie = MovieApiClient()

    suspend fun getMovieList(limit:Int): MoviesObject? = apiMovie.getMovieList(limit)

    suspend fun getMovieInfo(numberMovie:Int): Movie?  = apiMovie.getMovieInfo(numberMovie)
}