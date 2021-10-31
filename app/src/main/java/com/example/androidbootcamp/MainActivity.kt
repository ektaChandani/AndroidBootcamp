package com.example.androidbootcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :AppCompatActivity() {

//    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TestViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        colourbutton.setOnClickListener {
            colourFragmentLayout.setBackgroundColor(viewModel.colour)
            viewModel.changeBackgroundColor()

        }
    }

        override fun onResume() {
            super.onResume()
            // Getting last updated value from viewModel
            // So that in case of configuration change,last updated value remains with user
            colourFragmentLayout.setBackgroundColor(viewModel.colour)
        }
    }
