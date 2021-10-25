package com.example.androidbootcamp.Thread

import android.util.Log

class Thread1: Thread() {

    val TAG = "thread1"

    override fun run() {
        for(i in 1..4) {
            try {
                Thread.sleep(500)
            } catch (e: Exception) {
                Log.i(TAG,"e")
            }
            Log.i(TAG, "value$i")
        }
    }


}