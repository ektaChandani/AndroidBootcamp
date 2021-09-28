package com.example.androidbootcamp
import com.example.androidbootcamp.exercise.*


fun main() {


// Q2 WAP to create sealed Base class and 3 subclasses of Base class, write a function which will have
// base class object as an argument and it will return name of the subclass based argument type.
    println("\nQ2")
    val ob1 = Circle()
    val ob2 = Square()
    val ob3 = Rectangle()
    ob1.getShape()
    ob2.getShape()
    ob3.getShape()
//    var obj = ext()
//   obj.getShape()


// Q3 WAP to create extension function.
    println("\n Question 3")
    val ob4 = Question3()
    println("Using extension function:")
    ob4.printDetails()


    // Q1 WAP to create singleton class.
    println("\nQuestion1 \n singleton class")
    println("The sum of two values are: ${Question1.add(2, 3)}")

}



