package com.example.myproject.data

import com.example.myproject.albums.Album
import com.google.gson.annotations.SerializedName

class GetAlbumsResponse(
    @SerializedName("release-groups") val albums: List<Album>
)
