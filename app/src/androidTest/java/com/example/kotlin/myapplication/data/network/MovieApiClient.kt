package com.example.kotlin.myapplication.data.network

import com.example.kotlin.myapplication.data.network.MovieAPIService



class MovieApiClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(limit:Int): com.example.kotlin.myapplication.data.network.model.MoviesObject?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getMovieInfo(numberMovie:Int): Movie? {
        api = NetworkModuleDI()
        return try{
            api.getMovieInfo(numberMovie)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}