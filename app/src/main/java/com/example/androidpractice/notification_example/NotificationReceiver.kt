package com.example.androidpractice.notification_example

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.androidpractice.MainActivity
import com.example.androidpractice.R

class NotificationReceiver : BroadcastReceiver() {
    @SuppressLint("MissingPermission")
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == NotificationActivity.ACTION_UPDATE_NOTIFICATION) {
            val intent1 = Intent(context, MainActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(context, 0, intent1, PendingIntent.FLAG_IMMUTABLE)
            val updatedNotification =
                NotificationCompat.Builder(context, NotificationActivity.CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle("Updated notification")
                    .setContentText("Updated content")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                    .build()

            val notificationManager = NotificationManagerCompat.from(context)
            notificationManager.notify(NotificationActivity.NOTIFICATION_ID, updatedNotification)
        }
    }
}