package com.example.androidbootcamp.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp.Adapters.MyAdapter
import com.example.androidbootcamp.Models.MyData
import com.example.androidbootcamp.Models.Post
import com.example.androidbootcamp.R
import com.example.androidbootcamp.Retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity:AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var dataList = ArrayList<Post>()
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvDetails)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
        myAdapter = MyAdapter(baseContext , dataList)
        recyclerView.adapter=myAdapter



        getDetails()



    }

    private fun getDetails(){
        val detailData = ApiClient.getClient.getData()

        detailData.enqueue(object : Callback<MyData?>{

            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responseBody = response.body()!!
                val xy = responseBody?.posts
                dataList.addAll(xy)
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("MainActivity" , "onFailure:" + t.message)

            }

        })


    }
}


