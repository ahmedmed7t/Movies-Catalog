package com.example.moviescatalog.app

import android.view.View

// View extensions
fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

// String extensions
fun String.toOriginalImage(): String {
    return "https://image.tmdb.org/t/p/original$this"
}

fun String.toW500Image(): String {
    return "https://image.tmdb.org/t/p/w500$this"
}