package com.example.kotlin.myapplication.framework.views.activities

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.kotlin.myapplication.data.MovieRepository
import com.example.kotlin.myapplication.data.network.model.Movie.Movies
import com.example.kotlin.myapplication.databinding.ActivityMovieDetailBinding
import com.example.kotlin.myapplication.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailActivity : Activity() {
    private lateinit var binding: ActivityMovieDetailBinding
    private var movieUrl: String? = null
    private val movieRepository = MovieRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeBinding()
        manageIntent()
        obtainMovieData()
    }

    private fun initializeBinding() {
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun manageIntent() {
        if (intent != null) {
            movieUrl = intent.getStringExtra(Constants.URL_MOVIE)
            Log.d("Salida", movieUrl.toString())
        }
    }

    private fun obtainMovieData() {

        val movieNumber = movieUrl?.split("/")?.get(6)



        CoroutineScope(Dispatchers.IO).launch {
            val movie =
                movieNumber?.let { movieRepository.getMovieInfo(movieNumber.toInt()) }

            withContext(Dispatchers.Main) {
                movie?.let { updateMovieDetails(it) }
            }

        }

    }

    private fun updateMovieDetails(movie: Movies) {



    }

    //TODO: Refactor this
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
            Color.parseColor(lightenColor(getColor(type), -0.3f))

        val shapeDrawable = GradientDrawable()
        shapeDrawable.cornerRadius = cornerRadius


        shapeDrawable.setStroke(2, Color.parseColor(secondColor))


        shapeDrawable.setColor(backgroundColor)

        return shapeDrawable

    }

    private fun generateBackground(type: String): GradientDrawable {
        val backgroundColor =
            Color.parseColor(getColor(type))

        val shapeDrawable = GradientDrawable()

        shapeDrawable.cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, 80f, 80f, 80f, 80f)



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