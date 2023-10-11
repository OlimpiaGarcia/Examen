package com.example.kotlin.examv2.domain

import com.example.kotlin.examv2.data.MovieRepository
import com.example.kotlin.examv2.data.network.model.movieObject

class MovieListRequirement {

    private val repository = MovieRepository()

    suspend operator fun invoke(
        limit:Int
    ): movieObject? = repository.getList(limit)
}