package com.example.myproject.data

import com.example.myproject.presentation.home.favArtists.Artist
import com.google.gson.annotations.SerializedName

data class GetArtistResponse(
    @SerializedName("artists") val artists: List<Artist>) {
}
