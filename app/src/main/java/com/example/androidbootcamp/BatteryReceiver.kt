package com.example.androidbootcamp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val batteryLevel = intent?.getIntExtra("level",0)?: return
        if (batteryLevel!=0){
            Toast.makeText(context, "Batter percentage $batteryLevel%", Toast.LENGTH_SHORT).show()
        }
    }

}