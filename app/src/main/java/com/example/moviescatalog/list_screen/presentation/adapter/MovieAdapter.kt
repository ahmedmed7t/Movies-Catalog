package com.example.moviescatalog.list_screen.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviescatalog.R
import com.example.moviescatalog.app.toW500Image
import com.example.moviescatalog.databinding.MovieListItemBinding
import com.example.moviescatalog.list_screen.domain.models.MovieUiModel

class MovieAdapter(
    private val onMovieClicked: (MovieUiModel) -> Unit
) : ListAdapter<MovieUiModel, MovieAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val view: MovieListItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bind(uiModel: MovieUiModel) = with(view) {
            root.setOnClickListener { onMovieClicked(uiModel) }
            Glide.with(root.context).load(uiModel.posterPath.toW500Image()).error(R.drawable.failed_image).into(movieItemImage)
            movieItemTitle.text = uiModel.title
            movieItemRating.text = uiModel.voteAverage.toString()
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<MovieUiModel>() {

    override fun areItemsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean =
        oldItem == newItem
}