package com.example.kotlin.myapplication.domain


import com.example.kotlin.myapplication.data.MovieRepository
import com.example.kotlin.myapplication.data.network.model.Movie.Movies

class MovieInfoRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(
        numberMovie:Int
    ): Movies? = repository.getMovieInfo(numberMovie)
}