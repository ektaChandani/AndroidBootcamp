package com.example.androidbootcamp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.androidbootcamp.databinding.ActivityMainBinding

class MainActivity :AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.testviewmodel = viewModel
//        viewModel.observe(this, {
//            binding.testviewmodel.toString()
//        })

//        viewModel.currentNumber.observe(this, Observer {
//        textview2.text= it.toString()
//        })
//
//        viewModel.currentBoolean.observe(this, Observer {
//            textview1.text = it.toString()
//        })

//        generateColor()
    }


    }
