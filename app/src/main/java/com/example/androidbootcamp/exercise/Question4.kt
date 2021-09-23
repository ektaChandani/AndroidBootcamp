package com.example.androidbootcamp.exercise

    abstract class Library {
        var bookName: String = ""
        var bookID: Int = 0
        var bookAuthor: String = ""

        abstract fun addbook(bkName: String, bkID: Int, bkAutor: String)

        abstract fun getbookDetails()
    }

    class Question4: Library(){

        override fun addbook(bkName: String, bkID: Int, bkAutor: String) {
            bookName = bkName
            bookID = bkID
            bookAuthor = bkAutor
        }

        override fun getbookDetails() {
            println("Book id: $bookID")
            println("Book name: $bookName")
            println("Book author: $bookAuthor\n")
        }
    }
