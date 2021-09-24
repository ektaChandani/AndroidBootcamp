package com.example.androidbootcamp.exercise

abstract class Library {
    abstract fun addBook(bkName: String, bkID: Int, bkAuthor: String)
}

interface BookDetails{
    fun getBookDetails()
}

class Question4: Library(), BookDetails{
    private var bookName: String = ""
    private var bookID: Int = 0
    private var bookAuthor: String = ""

    override fun addBook(bkName: String, bkID: Int, bkAuthor: String) {
        bookName = bkName
        bookID = bkID
        bookAuthor = bkAuthor
    }

    override fun getBookDetails() {
        println("Book id: $bookID")
        println("Book name: $bookName")
        println("Book author: $bookAuthor\n")
    }
}