package com.example.kotlin.myapplication.data

import com.example.kotlin.myapplication.data.network.MovieApiClient
import com.example.kotlin.myapplication.data.network.model.Movie.Movies
import com.example.kotlin.myapplication.data.network.model.MovieObject


class MovieRepository() {
    private val apiMovie = MovieApiClient()

    suspend fun getMovieList(limit:Int): MovieObject? = apiMovie.getMovieList(limit)

    suspend fun getMovieInfo(numberMovie:Int): Movies?  = apiMovie.getMovieInfo(numberMovie)
}