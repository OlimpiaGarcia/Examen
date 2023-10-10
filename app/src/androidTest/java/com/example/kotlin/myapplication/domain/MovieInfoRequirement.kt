package com.example.kotlin.myapplication.domain


import com.example.kotlin.myapplication.data.MovieRepository

class MovieInfoRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(
        numberMovie:Int
    ): Movie? = repository.getMovieInfo(numberMovie)
}