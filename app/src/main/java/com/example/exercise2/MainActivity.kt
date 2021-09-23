package com.example.exercise2

import com.example.exercise2.exercise.BOI
import com.example.exercise2.exercise.ICICI
import com.example.exercise2.exercise.SBI

fun main() {

    // Q3 Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide
    // there specific details like rateofinterest etc,print details of every bank.
    println("\nQ3")
    val ob3 = SBI()
    ob3.getBankDetails()
    val ob4 = BOI()
    ob4.getBankDetails()
    val ob5 = ICICI()
    ob5.getBankDetails()


}