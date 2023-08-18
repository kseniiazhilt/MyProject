package com.example.myproject.presentation.home.favArtists

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
): Parcelable{

}
