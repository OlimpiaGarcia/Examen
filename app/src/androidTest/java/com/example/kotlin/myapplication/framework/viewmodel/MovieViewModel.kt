package com.example.kotlin.myapplication.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.myapplication.data.network.model.MovieObject
import com.example.kotlin.myapplication.domain.MovieListRequirement
import com.example.kotlin.myapplication.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel:ViewModel() {

    val MovieObjectLiveData = MutableLiveData<MovieObject>()
    private val pokemonListRequirement = MovieListRequirement()

    fun getMovieList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: MovieObject? = pokemonListRequirement(Constants.MAX_POKEMON_NUMBER)
            Log.d("SalidaCOunt", result?.count.toString())
            CoroutineScope(Dispatchers.Main).launch {
                pokedexObjectLiveData.postValue(result!!)
            }
        }    }
}