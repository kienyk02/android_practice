package com.example.androidpractice.notification_example

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.MainActivity
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    private val binding: ActivityNotificationBinding by lazy {
        ActivityNotificationBinding.inflate(layoutInflater)
    }
    private val notificationReceiver = NotificationReceiver()

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                createNotification()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentFilter = IntentFilter()
        intentFilter.addAction(ACTION_UPDATE_NOTIFICATION)
        registerReceiver(notificationReceiver, intentFilter)

        binding.apply {
            openNoti.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
                } else {
                    createNotification()
                }
            }
            updateNoti.setOnClickListener {
                updateNotification()
            }
            cancelNoti.setOnClickListener {
                cancelNotification()
            }
        }

    }

    private fun createNotificationChannel() {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(CHANNEL_ID, "test channel", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification() {
        createNotificationChannel()
        val intentUpdate = Intent().apply {
            action = ACTION_UPDATE_NOTIFICATION
        }
        val pendingUpdate =
            PendingIntent.getBroadcast(
                this,
                0,
                intentUpdate,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("hello")
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.ic_launcher_background, "Update Notification", pendingUpdate)
            .setAutoCancel(true)
            .build()

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    private fun updateNotification() {
        createNotificationChannel()
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Updated notification")
            .setContentText("Updated content")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, notification)
    }

    private fun cancelNotification() {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(NOTIFICATION_ID)
    }

    companion object {
        const val CHANNEL_ID = "CHANNEL_ID"
        const val NOTIFICATION_ID = 1
        const val ACTION_UPDATE_NOTIFICATION = "ACTION_UPDATE_NOTIFICATION"
    }
}