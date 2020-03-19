package com.example.android_2.data.networking

import com.example.android_2.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface MyApi {

    @GET("posts")
    fun getAllPosts(): Call<List<Post>>
}