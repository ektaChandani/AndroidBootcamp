package com.example.androidbootcamp.exercise


sealed class Question2 {
    val message="Shapes are Circle , square"
    fun getShape(base:Question2){
        println("This is class from ${base.javaClass}")
    }
    class Circle:Question2(){

    }
    class Square:Question2(){
    }
    class Rectangle : Question2(){

    }




}
