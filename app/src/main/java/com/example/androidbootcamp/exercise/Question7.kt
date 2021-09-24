package com.example.androidbootcamp.exercise

class Question7 {
        fun makeAndPrintMap() {
            val mMap = mutableMapOf(Pair(1, "hello"), Pair(2, "Ekta"), Pair(3, "world"))
            for (item in mMap) {
                println("Key: ${item.key}, Value: ${item.value}")
            }
        }
}