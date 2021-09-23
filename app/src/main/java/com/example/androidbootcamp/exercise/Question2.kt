package com.example.androidbootcamp.exercise

import android.graphics.Point

class Question2 {

     fun add(a: Int = 10, b: Int = 20) {
        val sum = a+b
        println("The sum of two integers: ${a+b}")


    }
     fun add(a:Double , b:Double){
        val sum = a+b
        println("The sum of two Double Numbers : $sum")
    }
     fun add(first:Int , second:Int , result : Int){
        val result = first*second
        println("The multiply of two Integer Numbers : $result")
    }
    fun add(first:String, second:String , result : String){
        val result = first.plus(second)
        println("The Concatenation of two Strings  : ${first +  " " + second}")
    }
    fun add(first:String, second:String , third :String , result : String){
        val result = first.plus(second).plus(third)
        println("The Concatenation of three Strings  : ${first +  " " + second + " " + third}")
    }






    }