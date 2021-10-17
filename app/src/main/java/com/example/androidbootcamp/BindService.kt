package com.example.androidbootcamp

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class BindService : Service() {

    private val myBinder = MyLocalBinder()

    class MyLocalBinder: Binder() {
        fun getService(): BindService {
            return BindService()
        }
    }



    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
            Locale.US)
        return dateformat.format(Date())
    }


    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }
}