package com.example.androidbootcamp

import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class MainActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //reference checkbox
        val checkbox = findViewById<CheckBox>(R.id.checkbox1)
        checkbox.setOnCheckedChangeListener { compoundButton, b -> checkbox.setText(
            if(compoundButton.isChecked) "Content marked Favourite" else "Content marked unfavourite"
        ) }
    }
}