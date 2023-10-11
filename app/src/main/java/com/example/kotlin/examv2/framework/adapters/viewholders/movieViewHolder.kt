package com.example.kotlin.examv2.framework.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.examv2.data.network.model.movieBase
import com.example.kotlin.examv2.databinding.ItemMovieBinding


class movieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: movieBase, context: Context) {
        binding.TVName.text = item.title
        binding.TVDescription.text = item.overview
        val urlImage = "https://image.tmdb.org/t/p/original${item.poster_path}"

        //Log.d("urlImage",urlImage)
        val requestOptions = RequestOptions()
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .fitCenter()
            .priority(Priority.HIGH)

        Glide.with(context).load(urlImage)
            .apply(requestOptions)
            .into(binding.IVPhoto)
    }
}

