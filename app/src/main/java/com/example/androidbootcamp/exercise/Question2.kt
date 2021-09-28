package com.example.androidbootcamp.exercise


sealed class Question2 {
    fun getShape() {
        println("This is class from ${this.javaClass}")
    }
}
class Circle:Question2(){
//        fun getName(){
//            getShape()
//        }

    }
class Square:Question2(){
//        fun getName(){
//            getShape()
//        }
    }
class Rectangle : Question2(){
    }
