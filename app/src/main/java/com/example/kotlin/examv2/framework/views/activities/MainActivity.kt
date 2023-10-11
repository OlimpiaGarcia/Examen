package com.example.kotlin.examv2.framework.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examv2.data.network.model.movieBase
import com.example.kotlin.examv2.databinding.ActivityMainBinding
import com.example.kotlin.examv2.framework.adapters.movieAdapter
import com.example.kotlin.examv2.framework.viewModel.mainViewModel

class MainActivity: AppCompatActivity() {

    //Global variables
    private lateinit var binding: ActivityMainBinding
    private val adapter: movieAdapter = movieAdapter()
    private lateinit var data:ArrayList<movieBase>

    private val viewModel: mainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList:ArrayList<movieBase>){
        binding.RVMovie.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVMovie.layoutManager = linearLayoutManager
        adapter.movieAdapter(dataForList,this)
        binding.RVMovie.adapter = adapter
    }

    private fun initializeObservers(){
        viewModel.movieObjectLiveData.observe(this) { movieObject ->
            if (movieObject != null) {
                setUpRecyclerView(movieObject.results)
            }
        }
    }

}