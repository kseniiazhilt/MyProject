package com.example.myproject.data

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("User-agent", "MusicBrainzAndroid (user, email@email.com)")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }
}