package com.example.androidbootcamp

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class TestViewModel: ViewModel() {


    fun generateColor(): Int {

        val random: Random = Random
        val color: Int =
            Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
//            viewModel.currentNumber.value =++viewModel.number
//            viewModel.currentBoolean.value=viewModel.number%2==0

        return color
    }

}

//    var number = 0
//    val currentNumber:MutableLiveData<Int> by lazy {
//        MutableLiveData<Int>()
//    }
//
//    val currentBoolean :MutableLiveData<Boolean> by lazy {
//        MutableLiveData<Boolean>()
//    }


