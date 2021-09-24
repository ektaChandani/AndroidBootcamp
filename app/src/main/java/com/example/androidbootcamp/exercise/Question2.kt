package com.example.androidbootcamp.exercise


class Question2 {

     fun add(a: Int = 10, b: Int = 20) {
        println("The sum of two integers: ${a+b}")
    }
     fun add(a:Double , b:Double){
        val sum = a+b
        println("The sum of two Double Numbers : $sum")
    }
     fun multiply(first:Int , second:Int ){
        val result = first*second
        println("The multiply of two Integer Numbers : $result")
    }
    fun concat(first:String, second:String) {
        println("The Concatenation of two Strings  : ${"$first $second"}")
    }
    fun concat1(first:String, second:String , third :String ){
        println("The Concatenation of three Strings  : ${"$first $second $third"}")
    }






    }