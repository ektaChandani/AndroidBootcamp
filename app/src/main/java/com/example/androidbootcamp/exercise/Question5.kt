package com.example.androidbootcamp.exercise

class Question5 {

        fun getGrade(marks: Int): String {
            println("Your marks is $marks")
            return when(marks) {
                in 80..100 -> "Rockstar"
                in 70..80 -> "Excellent"
                in 60..70 -> "Very Good"
                in 50..60 -> "Good"
                else -> "Invalid input"
            }
        }
}