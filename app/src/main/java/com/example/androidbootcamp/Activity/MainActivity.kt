package com.example.androidbootcamp.Activity

import android.app.ProgressDialog
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp.Adapters.MyAdapter
import com.example.androidbootcamp.Models.Post
import com.example.androidbootcamp.R
import com.example.androidbootcamp.Retrofit.ApiClient
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity:AppCompatActivity() {

    lateinit var progressProgressDialog: ProgressDialog
   private val dataList = ArrayList<Post>()
    lateinit var recyclerView: RecyclerView
    lateinit var imageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvDetails)
        imageView = findViewById(R.id.image)


        Picasso.get()
            .load("         https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json")
            .placeholder(R.mipmap.ic_launcher_round)
            .into(imageView)


        recyclerView.adapter = MyAdapter(dataList)
        recyclerView.layoutManager = LinearLayoutManager(this)



        progressProgressDialog= ProgressDialog(this)
        progressProgressDialog.setTitle("Loading")
        progressProgressDialog.setCancelable(false)
        progressProgressDialog.show()
        Handler.postDelayed({getDetails()} ,3000)
    }

    private fun getDetails(){
        progressProgressDialog.show()
        val call: Call<MutableList<Post>> = ApiClient.getClient.getData()

        call.enqueue(object : Callback<List<Post>?>{

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                progressProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                progressProgressDialog.dismiss()
            }

        })


    }
}


