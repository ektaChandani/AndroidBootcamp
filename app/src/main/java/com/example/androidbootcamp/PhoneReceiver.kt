package com.example.androidbootcamp
import android.content.BroadcastReceiver
import android.content.Context
import android.telephony.TelephonyManager

import android.content.Intent
import android.widget.Toast


class PhoneReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent) {
        if (intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
                .equals(TelephonyManager.EXTRA_STATE_RINGING)
        ) {
            Toast.makeText(context, "Incoming Call", Toast.LENGTH_SHORT).show()
        }
    }

}