package com.example.androidbootcamp

data class Employee(val name: String, val age: Int)

class Question2 {
    private val employeeList = listOf(
        Employee("Alexander", 23),
        Employee("Rohit", 35),
        Employee("John", 40),
        Employee("Dev", 32),
        Employee("Joe", 24),
        Employee("Shank", 44)
    )

    fun createFilteredList(){
        val ageFilteredList = employeeList.filter {
            (it.age > 30)
        }

        ageFilteredList.forEach {
            println("Name: ${it.name}, Age: ${it.age}")
        }
    }
}