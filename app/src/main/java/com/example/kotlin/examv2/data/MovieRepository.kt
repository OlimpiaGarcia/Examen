package com.example.kotlin.examv2.data

import com.example.kotlin.examv2.data.network.model.movie.Movies
import com.example.kotlin.examv2.data.network.model.movieObject
import com.example.kotlin.examv2.data.network.movieAPIService
import com.example.kotlin.examv2.data.network.networkModuleDI
import com.example.kotlin.examv2.utils.Constants

class MovieRepository() {

    private lateinit var apiMovie: movieAPIService

    suspend fun getList(limit:Int):movieObject?{
        apiMovie = networkModuleDI()
        return try{
            apiMovie.getList(Constants.API_KEY,limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getInfo(numberMovie:Int): Movies? {
        apiMovie = networkModuleDI()
        return try{
            apiMovie.getInfo(numberMovie)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}