package com.example.kotlin.myapplication.domain

import com.example.kotlin.myapplication.data.MovieRepository
import com.example.kotlin.myapplication.data.network.model.MovieObject

class MovieListRequirement {

    private val repository = MovieRepository()

    suspend operator fun invoke(
        limit:Int
    ): MovieObject? = repository.getMovieList(limit)
}