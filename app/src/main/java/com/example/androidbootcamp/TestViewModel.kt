package com.example.androidbootcamp

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class TestViewModel: ViewModel() {


    private val colorArray = arrayOf(
        Color.BLACK,
        Color.BLUE,
        Color.DKGRAY,
        Color.GRAY,
        Color.GREEN,
        Color.MAGENTA
    )

    var colour = colorArray[0]


    //Setting Background
    fun changeBackgroundColor() {
        colour = colorArray[randomNumberGenerator()]
    }

    // Generate random number
    private fun randomNumberGenerator(): Int {
        val startRange = 0
        val endRange = colorArray.size
        return Random.nextInt(startRange, endRange)
    }
}