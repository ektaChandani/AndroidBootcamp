package com.example.androidbootcamp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity :AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        justOperator()
//        fromOperator()
//        fromIterableOperator()
//        rangeOperator().subscribe(
//            {
//                Log.d(TAG, "onNext :$it")
//
//            },
//            {
//                Log.d(TAG, "onError ${it})")
//
//            },
//            {
//                Log.d(TAG, "onComplete")
//
//            }
//        )

//        repeatOperator().subscribe(
//            {
//                Log.d(TAG, "onNext :${it}")
//
//            },
//            {
//                Log.d(TAG, "onError :${it}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//
//            }
//        )
//        intervalOperator().subscribe(
//                        {
//                Log.d(TAG, "onNext :${it}")
//
//            },
//            {
//                Log.d(TAG, "onError :${it}")
//            },
//            {
//                Log.d(TAG, "onComplete")
//
//            }
//
//        )

        filterOperator().filter{
            it.age>25
        }
            .subscribe(
            {
                Log.d(TAG, "onNext :${it}")

            },
            {
                Log.d(TAG, "onError :${it}")
            },
            {
                Log.d(TAG, "onComplete")

            }

        )
    }
    private fun getLocation(){
        Log.d(TAG,"Latitude:102.0303 Longitude 1.2355")
    }
}