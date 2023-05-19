package com.example.moviescatalog.list_screen.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.addPagination(
    loadMoreItems: () -> Unit
) {
    val layoutManager = this.layoutManager as? LinearLayoutManager
        ?: throw IllegalStateException("RecyclerView must have LinearLayoutManager.")

    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = layoutManager.childCount
            val totalItemCount = layoutManager.itemCount
            val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                loadMoreItems()
            }
        }
    })
}