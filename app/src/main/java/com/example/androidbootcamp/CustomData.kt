package com.example.androidbootcamp

class CustomData(val title: String,
                val address: String,
                val imageID: Int, val
                StarRatings: Int, val
                noOfReview: String,
                val date: String,
                val amount: String){
    companion object {

        fun getData(): ArrayList<CustomData> {
            val datatosend = ArrayList<CustomData>()

            for (i in 1..5) {
                datatosend.add(
                    getCustomData()

                )
            }
            return datatosend
        }

        fun getCustomData() : CustomData{
            return CustomData(
                "Ice Cream Sundae",
                "145, Mall of India",
                R.drawable.menu1,
                4,
                "500 reviews",
                "05 Oct 2021 2 : 00 PM",
                "Rs. 200"
            )

        }

    }
}

