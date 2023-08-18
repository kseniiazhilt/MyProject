package com.example.myproject.albums

import android.graphics.drawable.Drawable
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    @SerializedName("title")
    val title: String,
    @SerializedName("primary-type")
    val type: String,
    @SerializedName("first-release-date")
    val year: Int,
    var isFavourite: Boolean = false
): Parcelable{

}