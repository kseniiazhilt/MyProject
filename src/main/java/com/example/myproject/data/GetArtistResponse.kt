package com.example.myproject.data

import android.os.Parcel
import android.os.Parcelable
import com.example.myproject.presentation.home.favArtists.Artist
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

data class GetArtistResponse(
    @SerializedName("artists") val artists: List<Artist>){

    }
