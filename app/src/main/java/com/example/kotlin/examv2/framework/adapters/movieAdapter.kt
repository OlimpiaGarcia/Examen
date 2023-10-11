package com.example.kotlin.examv2.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examv2.data.network.model.movieBase
import com.example.kotlin.examv2.databinding.ItemMovieBinding
import com.example.kotlin.examv2.framework.adapters.viewholders.movieViewHolder


class movieAdapter: RecyclerView.Adapter<movieViewHolder>(){
    var data:ArrayList<movieBase> = ArrayList()
    private lateinit var context: Context

    fun movieAdapter(basicData : ArrayList<movieBase>, context:Context){
        this.data = basicData
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return movieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}