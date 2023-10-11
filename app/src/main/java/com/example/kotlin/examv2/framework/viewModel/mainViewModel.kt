package com.example.kotlin.examv2.framework.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examv2.data.network.model.movieObject
import com.example.kotlin.examv2.domain.MovieListRequirement
import com.example.kotlin.examv2.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class mainViewModel: ViewModel() {

    val movieObjectLiveData = MutableLiveData<movieObject>()
    private val movieListRequirement = MovieListRequirement()

    fun getList(){
        viewModelScope.launch {
            Dispatchers.IO
            val result: movieObject? = movieListRequirement(Constants.MAX_MOVIE_NUMBER)
            CoroutineScope(Dispatchers.Main).launch {
                movieObjectLiveData.postValue(result!!)
            }
        }}}