package com.example.androidbootcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidbootcamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding:ActivityMainBinding
    private lateinit var manager:RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

     var data = listOf(DataModel(name = "Ekta" , email = "ekta@gmail.com" , phoneNumber = 123456789 , address = "alambagh") )
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)
        binding.rvList.apply{
            adapter = RecyclerViewAdapter(data)
            layoutManager = manager

        }


    }
}
