package com.example.myproject.albums

import android.graphics.drawable.Drawable

data class Album (
    val title: String,
    val type: String,
    val year: Int,
    val image: Drawable?,
    var isFavourite: Boolean = false
)