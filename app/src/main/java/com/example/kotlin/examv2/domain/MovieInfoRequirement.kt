package com.example.kotlin.examv2.domain

import com.example.kotlin.examv2.data.MovieRepository
import com.example.kotlin.examv2.data.network.model.movie.Movies

class MovieInfoRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(
        numberMovie:Int
    ): Movies? = repository.getInfo(numberMovie)
}