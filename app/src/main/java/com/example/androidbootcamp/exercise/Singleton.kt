package com.example.androidbootcamp.exercise

object Singleton {

        init {
            println("Singleton class invoked.")
        }
        var fname = "Ekta"
        var lname = "Chandani"
        var fullname="Ekta Chandani"
        fun printVarName(){
            println(fname)
            println(lname)
            println(fullname)

        }

    }

    fun main(args: Array<String>) {
        Singleton.printVarName()
        Singleton.fullname= "My Singleton class"
//        Singleton.fname = "I am inside Singleton class"
//        Singleton.lname = " I am in outside class"

        var a = A()
    }

    class A {

        init {
            println("${Singleton.fullname} ")
            Singleton.printVarName()
        }
    }


