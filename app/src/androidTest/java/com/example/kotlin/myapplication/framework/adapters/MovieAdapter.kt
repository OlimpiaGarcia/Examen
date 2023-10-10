package com.example.kotlin.myapplication.framework.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.myapplication.data.network.model.MovieBase
import com.example.kotlin.myapplication.framework.adapters.viewholders.MovieViewHolder
import com.example.kotlin.myapplication.databinding.ItemMovieBinding


class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    lateinit var context: Context
    var data:ArrayList<MovieBase> = ArrayList()


    @SuppressLint("NotConstructor")
    fun MovieAdapter(basicData : ArrayList<MovieBase>, context:Context){
        this.data = basicData
        this.context = context
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }


}