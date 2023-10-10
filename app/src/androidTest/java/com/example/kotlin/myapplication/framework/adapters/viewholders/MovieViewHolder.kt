package com.example.kotlin.myapplication.framework.adapters.viewholders

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.myapplication.R
import com.example.kotlin.myapplication.data.network.model.Movie.Movies
import com.example.kotlin.myapplication.data.network.model.MovieBase
import com.example.kotlin.myapplication.databinding.ItemMovieBinding
import com.example.kotlin.myapplication.domain.MovieInfoRequirement
import com.example.kotlin.myapplication.utils.Constants
import com.example.kotlin.pokedexapp.framework.views.activities.MovieDetailActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: MovieBase, context: Context) {
        binding.TVName.text = item.name
        getMovieInfo(item.url, binding.IVPhoto, context)

        binding.llPokemon.setOnClickListener {
            passViewGoToMovieDetail(item.url, context)
        }
    }

    private fun passViewGoToMovieDetail(url: String, context: Context) {
        val intent: Intent = Intent(context, MovieDetailActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.putExtra(Constants.URL_MOVIE, url)
        context.startActivity(intent)
    }

    private fun getMovieInfo(url: String, imageView: ImageView, context: Context) {
        //" https://api.themoviedb.org/3/movie/popular"
        var movieStringNumber: String = url.replace(" https://api.themoviedb.org/3/movie/popular", "")
        movieStringNumber = movieStringNumber.replace("/", "")
        val movieNumber: Int = Integer.parseInt(movieStringNumber)

        CoroutineScope(Dispatchers.IO).launch {
            val movieInfoRequirement = MovieInfoRequirement()
            val result: Movies? = movieInfoRequirement(movieNumber)
            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = result?.results?.toString()

                val requestOptions =
                    RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                        .fitCenter().priority(Priority.HIGH)

                Glide.with(context).load(urlImage).apply(requestOptions).into(imageView)


                val card =
                    binding.llPokemon.findViewById<androidx.cardview.widget.CardView>(R.id.cvPokemon)
            }
        }
    }

    private fun getColor(type: String): String {
        when (type) {
            "fire" -> return "#fb6c6c"
            "water" -> return "#76bdfe"
            "grass" -> return "#48d0b0"
            "electric" -> return "#ffd86f"
            "poison" -> return "#c183c1"
            "bug" -> return "#c6d16e"
            "ground" -> return "#ebd69d"
            "fairy" -> return "#ee99ac"
            "normal" -> return "#bcbcbc"
            "fighting" -> return "#d67873"
            "psychic" -> return "#fa8581"
            "rock" -> return "#d1c17d"
            "ghost" -> return "#a292bc"
            "ice" -> return "#bce6e6"
            "dragon" -> return "#a27dfa"
            "dark" -> return "#a29288"
            "steel" -> return "#d1d1e0"
            "flying" -> return "#c6b7f5"
        }
        return "#ffffff"
    }

    private fun generateShapeWBorder(type: String): GradientDrawable {
        val secondColor = getColor(type)

        val cornerRadius = 16f
        val backgroundColor =
            Color.parseColor(lightenColor(getColor(type), 0.2f))

        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = cornerRadius
        shapeDrawable.setColor(backgroundColor)

        return shapeDrawable

    }

    fun lightenColor(hexColor: String, factor: Float): String {
        val color = Color.parseColor(hexColor)
        val red = Color.red(color)
        val green = Color.green(color)
        val blue = Color.blue(color)

        val newRed = (red + (255 - red) * factor).toInt()
        val newGreen = (green + (255 - green) * factor).toInt()
        val newBlue = (blue + (255 - blue) * factor).toInt()

        val newColor = Color.rgb(newRed, newGreen, newBlue)
        return String.format("#%06X", 0xFFFFFF and newColor)
    }


}