package com.example.androidbootcamp.Repository

import com.example.androidbootcamp.retrofit.RetrofitService

class Repository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllData() = retrofitService.getAllData()

}
