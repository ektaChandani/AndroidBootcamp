package com.example.androidbootcamp


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidbootcamp.Thread.Thread1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    var myService: BindService? = null
    var isBound = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val myThread1 = Thread1()
        val myThread2 = Thread1()
        val myThread3 = Thread1()

        // thread t1 starts

        myThread1.start()

        // starts second thread when first thread t1 is died.
        try {
            myThread1.join()
        } catch (e: Exception) {
            println(e)
        }
        // start t2 and t3 thread
        // start t2 and t3 thread
        myThread2.start()
        myThread3.start()

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process

        service()
        bindLocalService()
        localServiceBtn.setOnClickListener {
            showTime()
        }


    }
    fun service() {


        val serviceIntent = Intent(this, NewService::class.java)
        startButton.setOnClickListener {
            startService(serviceIntent)
            Toast.makeText(this, "Music Started", Toast.LENGTH_SHORT).show()
        }
        stopButton.setOnClickListener {
            stopService(serviceIntent)
        }
    }

    private fun bindLocalService() {
        val intent = Intent(this, BindService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    private fun showTime() {
        val currentTime = myService?.getCurrentTime()
        Toast.makeText(this, "Current time is: ${currentTime.toString()}", Toast.LENGTH_SHORT)
            .show()
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as BindService.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }




}