package com.example.desafio_android_stant

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


class DescriptionMovieActivity : AppCompatActivity() {

    private lateinit var movieBackdrop : ImageView
    private lateinit var moviePosterCard : ImageView
    private lateinit var movieTitle : TextView
    private lateinit var movieReleaseDate : TextView
    private lateinit var movieOverview : TextView
    private lateinit var toolbarTitleText : TextView
    private lateinit var originaLanguage : TextView
    private lateinit var imageBack : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_movie)
        hideActionBar()
        initializeComponents()
        setComponentsById()
        clickButtonBackScreen()
    }

    private fun clickButtonBackScreen(){
        imageBack.setOnClickListener {
            finish()
        }
    }

    private fun hideActionBar(){
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }
    }

    private fun setComponentsById(){
        val intent = intent
        val title = intent.getStringExtra("movie_title")
        val backdrop = intent.getStringExtra("movie_backdrop")
        val poster = intent.getStringExtra("movie_poster_card")
        val date = intent.getStringExtra("movie_release_date")
        val overview = intent.getStringExtra("movie_overview")
        val language = intent.getStringExtra("original_language")
        movieTitle.setText(title)
        toolbarTitleText.setText(title)
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/"+backdrop)
            .into(movieBackdrop)
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/"+poster)
            .into(moviePosterCard)
        movieReleaseDate.setText(date)
        movieOverview.setText(overview)
        originaLanguage.setText("Original language : "+language)
    }

    private fun initializeComponents(){
        movieBackdrop = findViewById(R.id.movie_backdrop)
        moviePosterCard = findViewById(R.id.movie_poster)
        movieTitle = findViewById(R.id.movie_title)
        originaLanguage = findViewById(R.id.movie_original_language)
        movieReleaseDate = findViewById(R.id.movie_release_date)
        movieOverview = findViewById(R.id.movie_overview)
        toolbarTitleText = findViewById(R.id.txtTitleMovie);
        imageBack = findViewById(R.id.imgBtnBack)
    }
}