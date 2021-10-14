package com.example.androidbootcamp


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    // declaring objects of Button class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        val serviceIntent = Intent(this, NewService::class.java)
        startButton.setOnClickListener {
            startService(serviceIntent)
            Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show()
        }
        stopButton.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}