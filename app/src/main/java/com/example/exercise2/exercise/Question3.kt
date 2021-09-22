package com.example.exercise2.exercise

interface BankDetails {
    val ROI: Double
    val bankName: String
    val bankCity: String

    fun getBankDetails() {
        println("Bank name: $bankName")
        println("Bank city: $bankCity")
        println("Rate of Interest: $ROI\n")
    }

}

class SBI: BankDetails {
    override val ROI: Double
        get() = 10.0
    override val bankName: String
        get() = "SBI"
    override val bankCity: String
        get() = "New Delhi"
}

class BOI: BankDetails {
    override val ROI: Double
        get() = 15.0
    override val bankName: String
        get() = "BOI"
    override val bankCity: String
        get() = "Delhi"
}

class ICICI: BankDetails {
    override val ROI: Double
        get() = 8.0
    override val bankName: String
        get() = "ICICI"
    override val bankCity: String
        get() = "Noida"
}