package com.example.androidpractice.broadcasts_example

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityBroadCastsBinding

class BroadCastsActivity : AppCompatActivity() {
    private val binding: ActivityBroadCastsBinding by lazy {
        ActivityBroadCastsBinding.inflate(layoutInflater)
    }
    private val broadcastReceiver1 = BroadcastReceiver1()
    private val broadcastReceiver2 = BroadcastReceiver2()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentFilter = IntentFilter()
        intentFilter.addAction("ACTION")
        intentFilter.priority = 1
        registerReceiver(broadcastReceiver1, intentFilter)
        intentFilter.priority = 2
        registerReceiver(broadcastReceiver2, intentFilter)
//        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver1, intentFilter)

        binding.btnBroadCasts.setOnClickListener {
            sendBroadcast()
        }
    }

    private fun sendBroadcast() {
        val intent = Intent()
        intent.action = "ACTION"
        intent.putExtra("data", "kien")
//        sendBroadcast(intent)
//        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        sendOrderedBroadcast(intent, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver1)
        unregisterReceiver(broadcastReceiver2)
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver1)
    }
}