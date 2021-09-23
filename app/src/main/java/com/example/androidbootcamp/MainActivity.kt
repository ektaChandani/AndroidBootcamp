package com.example.androidbootcamp

import android.graphics.Point
import androidx.core.graphics.plus
import com.example.androidbootcamp.exercise.*

fun main() {

    // Q3 Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide
    // there specific details like rateofinterest etc,print details of every bank.
    println("\nQuestion 3")
    val ob3 = SBI()
    ob3.getBankDetails()
    val ob4 = BOI()
    ob4.getBankDetails()
    val ob5 = ICICI()
    ob5.getBankDetails()

    // Q1 Write a program to print your Firstname, LastName & age using init block,companion object.

        println("Question 1")
        // Making Object of class
        val ob1 = question1()
        // calling method
        ob1.printDetails()

        // printing details from Companion object
        println("\n Value initialised from companion object")
        println("First name: ${question1.fname}")
        println("Last name: ${question1.lname}")
        println("Age: ${question1.age}")

//    Write a single program for following operation using overloading
//            A) Adding 2 integer number
//    B) Adding 2 double
//    D) multiplying 2 int
//    E) concate 2 string
//    F) Concate 3 String

    println("Question 2")
    val ob = Question2()
    val obb = Question2()
    val obbb = Question2()
    val str= Question2()
    val str1= Question2()


    ob.add(a = 10,b=20)
    obb.add(a=10.0 , b=50.0)
    obbb.add(first = 50 , second = 25 , result = 0)
    str.add(first = "Ekta" , second = "Chandani" , result = "")
    str1.add(first = "Ekta" , second = "Chandani" , third = "Android  " , result = "")





    // Q4 Create Kotlin classes having suitable attributes for Library management system.Use OOPs concepts
    // in your design.Also try to use interfaces and abstract classes.
    println("\nQ4")
    val ob6 = Question4()
    val ob7 = Question4()
    ob6.addbook("Introduction to OOPs", 1, "Ekta")
    ob7.addbook("Introduction to Kotlib", 2, "Shweta")
    ob6.getbookDetails()
    ob7.getbookDetails()

    // Q5 Write a function which take marks as an argument and return the the grade as follows:
    //marks between 50 to 60 , return “Good”
    //marks between 60 to 70, return “Very Good”
    //marks between 70 to  80, return “Excellent”
    //marks between  80 to 100, return “Rockstar”
    println("\nQuestion5")
    val ob8 = Question5()
    println("Your grade: ${ob8.getGrade(55)}")

    // Q6 Write a program to create mutable list of Integer. replace the second item in the list with
    // new value. Print the list value.
    println("\n Question6")
    val ob9 = Question6()
    println("Original content in list: ${ob9.mlist}")
    ob9.replaceSecondItem()


    // Q7 Write a program to create mutable map. print all the value and key of map.
    println("\n Question 7")
    val ob10 = Question7()
    ob10.makeAndPrintMap()

    // Q8 Write a program to create HasSet. print all the value.
    println("\n Question 8")
    val ob11 = Question8()
    ob11.printHashSet()
}





