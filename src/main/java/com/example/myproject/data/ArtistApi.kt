package com.example.myproject.data

//import com.google.gson.Gson
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL =
    "https://musicbrainz.org/ws/2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .addInterceptor(HeaderInterceptor())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface ArtistApi {
    @GET("artist/")
    suspend fun getArtistByName(
        @Query("limit") limit: Int = 1,
        @Query("query") artistName: String
    ): GetArtistResponse

}

object ArtistObject {
    val retrofitService : ArtistApi by lazy {
        retrofit.create(ArtistApi::class.java)
    }
}