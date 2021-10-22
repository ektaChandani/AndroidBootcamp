package com.example.androidbootcamp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


const val BASE_URL =" https://jsonplaceholder.typicode.com"

class MainActivity :AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDetailsBtn.setOnClickListener {
            val getIdToFetch = edittext_id.text
            Log.i(TAG,"$getIdToFetch")

            if (getIdToFetch.isNullOrEmpty() || getIdToFetch.toString().toInt() > 10 || getIdToFetch.toString().toInt() < 1
            ) {
                edittext_id.error = "Enter digit between 1 to 10"
            } else {
                getMyData(getIdToFetch.toString().toInt())
            }


        }
    }

    private fun getMyData(id: Int) {

        val retrofitData=ApiClient.getApiClient()?.getAId(id)
        retrofitData?.enqueue(object : Callback<List<DataModelItem>?> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<List<DataModelItem>?>,
                response: Response<List<DataModelItem>?>
            ) {
                val responseBody = response.body()!!

                for (myData in responseBody) {
                    textview_id.text = "Post Id: ${myData.id}"
                    textview_title.text = "Title: ${myData.title}"
                    textview_body.text = "Body: ${myData.body}"

                }
            }
            override fun onFailure(call: Call<List<DataModelItem>?>, t: Throwable) {

                Log.d("MainActivity" , "onFailure:" +t.message)
            }
        })


    }
}

