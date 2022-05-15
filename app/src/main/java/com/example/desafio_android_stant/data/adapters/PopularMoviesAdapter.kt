package com.example.desafio_android_stant.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android_stant.R
import com.example.desafio_android_stant.data.models.ResponseResultModel
import com.squareup.picasso.Picasso

class PopularMoviesAdapter(private var movies: MutableList<ResponseResultModel>):RecyclerView.Adapter<PopularMoviesAdapter.PopularMoviesViewHolder>() {

    class PopularMoviesViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
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
    }

    override fun getItemCount(): Int =  movies.size
}