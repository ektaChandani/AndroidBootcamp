package com.example.androidbootcamp.exercise

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
        get() = 20.0
    override val bankName: String
        get() = "SBI"
    override val bankCity: String
        get() = "Lucknow"
}

class BOI: BankDetails {
    override val ROI: Double
        get() = 25.0
    override val bankName: String
        get() = "BOI"
    override val bankCity: String
        get() = "Mumbai"
}

class ICICI: BankDetails {
    override val ROI: Double
        get() = 5.0
    override val bankName: String
        get() = "ICICI"
    override val bankCity: String
        get() = "Gurgaon"
}