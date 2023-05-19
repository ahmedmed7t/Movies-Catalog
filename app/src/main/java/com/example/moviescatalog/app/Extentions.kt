package com.example.moviescatalog.app

import android.app.Activity
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.example.moviescatalog.R
import com.google.android.material.snackbar.Snackbar

// View extensions
fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

// Activity extensions
fun Activity.showErrorToast(text: String) {
    val parent: View = findViewById(android.R.id.content)
    val snackBar: Snackbar = Snackbar.make(parent, text, Snackbar.LENGTH_LONG)
    snackBar.view.background = AppCompatResources.getDrawable(this, R.drawable.error_toast_background)
    snackBar.show()
}

// String extensions
fun String.toOriginalImage(): String {
    return "https://image.tmdb.org/t/p/original$this"
}

fun String.toW500Image(): String {
    return "https://image.tmdb.org/t/p/w500$this"
}