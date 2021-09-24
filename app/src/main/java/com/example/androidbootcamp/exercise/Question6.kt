package com.example.androidbootcamp.exercise

class Question6 {
        val mList = mutableListOf<Int>(2, 4, 7, 12, 18)

        fun replaceSecondItem() {
            mList[2]  = 6
            printList()
        }

        private fun printList() {
            println("Updated content in list: $mList")
        }
}