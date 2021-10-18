package com.example.androidbootcamp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private val CHANNEL_ID = " channel_id"
    private val CHANNEL_NAME= "channelName"
    private val CHANNEL_ID_2 = " channel_id"
    private val CHANNEL_NAME_2= "channelName"
    private val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        createNotificationChannel()
        createNotificationChannel2()


        // creating notification channel 1

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("my notification")
            .setContentText("This is my notification")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        btnShowNotification.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }



        // creating notification channel 2
        val notification2 = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("my notification 2 ")
            .setContentText("This is my notification 2")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager2 = NotificationManagerCompat.from(this)
    }
// notification channel 1
    private fun createNotificationChannel2() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID_2,
                CHANNEL_NAME_2,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
// notification channel 2
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID_2,
                CHANNEL_NAME_2,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}