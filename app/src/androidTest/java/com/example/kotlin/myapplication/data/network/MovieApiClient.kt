package com.example.kotlin.myapplication.data.network

import com.example.kotlin.myapplication.data.network.MovieAPIService
import com.example.kotlin.myapplication.data.network.model.Movie.Movies


class MovieApiClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit:Int): com.example.kotlin.myapplication.data.network.model.MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getMovieInfo(numberMovie:Int): Movies? {
        api = NetworkModuleDI()
        return try{
            api.getMovieInfo(numberMovie)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}