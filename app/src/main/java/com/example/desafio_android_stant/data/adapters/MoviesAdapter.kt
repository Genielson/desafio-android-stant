package com.example.desafio_android_stant.data.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android_stant.DescriptionMovieActivity
import com.example.desafio_android_stant.R
import com.example.desafio_android_stant.data.models.ResponseResultModel
import com.squareup.picasso.Picasso

class MoviesAdapter(var context : Context, private var movies: MutableList<ResponseResultModel>):RecyclerView.Adapter<MoviesAdapter.PopularMoviesViewHolder>() {

    class PopularMoviesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image = view.findViewById<ImageView>(R.id.imgMovie)
        fun bind(resultModel: ResponseResultModel) {
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/"+resultModel.poster_path)
                .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_movie, parent, false)
        return PopularMoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val item = movies[position]
        holder.bind(item)
        holder.itemView.findViewById<ImageView>(R.id.imgMovie).setOnClickListener {
            val intent = Intent(context,DescriptionMovieActivity::class.java)
            intent.putExtra("movie_backdrop",item.backdrop_path)
            intent.putExtra("movie_poster_card",item.poster_path)
            intent.putExtra("movie_title",item.title)
            intent.putExtra("movie_release_date",item.release_date)
            intent.putExtra("movie_overview",item.overview)
            intent.putExtra("original_language",item.original_language)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int =  movies.size
}