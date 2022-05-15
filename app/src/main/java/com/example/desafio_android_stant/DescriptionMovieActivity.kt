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
        var title = intent.getStringExtra("movie_title")
        var backdrop = intent.getStringExtra("movie_backdrop")
        var poster = intent.getStringExtra("movie_poster_card")
        var date = intent.getStringExtra("movie_release_date")
        var overview = intent.getStringExtra("movie_overview")
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
    }

    private fun initializeComponents(){
        movieBackdrop = findViewById(R.id.movie_backdrop)
        moviePosterCard = findViewById(R.id.movie_poster)
        movieTitle = findViewById(R.id.movie_title)
        movieReleaseDate = findViewById(R.id.movie_release_date)
        movieOverview = findViewById(R.id.movie_overview)
        toolbarTitleText = findViewById(R.id.txtTitleMovie);
        imageBack = findViewById(R.id.imgBtnBack)
    }
}