package com.example.android_2.data.networking

import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit(context: Context) {

    val client = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .addNetworkInterceptor(ChuckInterceptor(context))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val myApiJson = retrofit.create(MyApi::class.java)

}