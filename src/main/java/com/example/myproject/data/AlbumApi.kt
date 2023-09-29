package com.example.myproject.data

import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://musicbrainz.org/ws/2/"

private val gson = GsonBuilder().create()

val clientAlbum = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .addInterceptor(HeaderInterceptor())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .client(clientAlbum)
    .build()

interface AlbumApi {
    @GET("release-group/")
    suspend fun getArtistAlbum(
        @Query("query") query: String
    ): GetAlbumsResponse
}

object AlbumsObject {
    val retrofitService: AlbumApi by lazy {
        retrofit.create(AlbumApi::class.java)
    }
}