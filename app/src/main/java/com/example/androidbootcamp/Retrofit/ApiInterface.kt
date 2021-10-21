package com.example.androidbootcamp.Retrofit

import com.example.androidbootcamp.Models.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

        @GET("v2/posts.json")
        fun getData():Call<MyData>


}