package com.example.androidbootcamp.exercise

class Question3 {
    private val num1: Int = 10
    private val str1 = "Kotlin"
    private val str2 = "World!"

    // Extension function
    // Adding functionality to existing
    // Int class
    private fun Int.addition(num2: Int): Int {
        return this+num2
    }

    // Extension function
    // Adding functionality to existing
    // String class
    private fun String.returnRemovedSpace(s: String, s1: String): String {
        return this + s + s1
    }

    fun printDetails() {
        println("Addition of 5 and 10: " + 5.addition(num1))
        println("After removing spaces from string Hello Kotlin World!: " + "Hello".returnRemovedSpace(str1, str2) + "\n\n")

    }
}