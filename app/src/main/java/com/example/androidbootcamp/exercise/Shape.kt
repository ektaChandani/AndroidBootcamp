package com.example.androidbootcamp.exercise

import kotlin.math.sqrt

sealed class Shape {
    val message="Shapes are Circle , square"
    fun getShape(base:Shape){
        println("This is class from ${base.javaClass}")
    }
    class Circle:Shape(){

    }
    class Square:Shape(){

    }
    class Rectangle : Shape(){

    }




}
