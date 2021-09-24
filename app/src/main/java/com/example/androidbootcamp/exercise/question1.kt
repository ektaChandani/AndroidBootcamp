package com.example.androidbootcamp.exercise

class Question1 {

    companion object {
        const val fname = "Deepshikha"
        const val lname = "Chandani"
        const val age = 29
    }

    var fname: String? = null
    var lname: String? = null
    var age: String? = null

    init {
        fname = "Ekta"
        lname = "Chandani"
        age = "25"

    }


    fun printDetails() {
        println("Value initialised from init block")
        println("First name: $fname")
        println("Last name: $lname")
        println("Age: $age")
    }

}
