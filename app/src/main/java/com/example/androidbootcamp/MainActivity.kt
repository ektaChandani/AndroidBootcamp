package com.example.androidbootcamp


import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    var myService: BindService? = null
    var isBound = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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