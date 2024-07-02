package com.example.androidpractice.broadcasts_example

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log

class BroadcastReceiver1 : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val data = p1?.getStringExtra("data")
        Log.d("BroadcastReceiver", "onReceive1: $data, result: $resultData")
    }
}

class BroadcastReceiver2 : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val data = p1?.getStringExtra("data")
        Log.d("BroadcastReceiver", "onReceive2: $data")
        setResult(0,"Hello", Bundle())
    }
}