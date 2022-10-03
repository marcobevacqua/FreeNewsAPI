package com.example.freenewstry.adapters

import com.example.freenewstry.BuildConfig
import com.example.freenewstry.interfaces.ClientEndPoints
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AdapterRest {

    var clientEndpoints: ClientEndPoints?= null

    fun init() {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)

        var client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request().newBuilder()
                        .addHeader("X-RapidAPI-Key", "847310f156msh94c344d4a1fb18fp15549cjsn88ea6d094e14")
                        .addHeader("X-RapidAPI-Host","free-news.p.rapidapi.com")
                    return chain.proceed(request.build())
                }
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        clientEndpoints = retrofit.create(ClientEndPoints::class.java)
    }
}