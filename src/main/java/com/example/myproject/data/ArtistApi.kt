package com.example.myproject.data
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://musicbrainz.org/ws/2/"

private val gson = GsonBuilder().create()

val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .addInterceptor(HeaderInterceptor())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
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