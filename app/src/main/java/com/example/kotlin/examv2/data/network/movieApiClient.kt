package com.example.kotlin.examv2.data.network

import com.example.kotlin.examv2.data.network.model.movie.Movies
import com.example.kotlin.examv2.utils.Constants


class movieApiClient {
    private lateinit var api: movieAPIService

    suspend fun getmovieList(limit:Int): com.example.kotlin.examv2.data.network.model.movieObject?{
        api = networkModuleDI()
        return try{
            api.getList(Constants.API_KEY, limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getInfo(numbermovie:Int): Movies? {
        api = networkModuleDI()
        return try{
            api.getInfo(numbermovie)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}
