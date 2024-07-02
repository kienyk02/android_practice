package com.example.androidpractice

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {
    private val binding: ActivitySharedPreferencesBinding by lazy {
        ActivitySharedPreferencesBinding.inflate(layoutInflater)
    }
    private val sharedPreferences: SharedPreferences by lazy {
        getSharedPreferences("helloSharePrefs", MODE_PRIVATE)
    }
    var curColor = "gray"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        reStoreValue()
        handleEvent()

    }

    @SuppressLint("SetTextI18n")
    private fun handleEvent() {
        binding.apply {
            btnCount.setOnClickListener {
                txtCount.text = (txtCount.text.toString().toInt()+1).toString()
            }
            btnReset.setOnClickListener {
                txtCount.text = "0"
                txtCount.setBackgroundColor(resources.getColor(R.color.gray, null))
                curColor = "gray"
            }
            btnBlack.setOnClickListener {
                txtCount.setBackgroundColor(resources.getColor(R.color.black, null))
                curColor = "black"
            }
            btnRed.setOnClickListener {
                txtCount.setBackgroundColor(resources.getColor(R.color.red, null))
                curColor = "red"
            }
            btnBlue.setOnClickListener {
                txtCount.setBackgroundColor(resources.getColor(R.color.blue, null))
                curColor = "blue"
            }
            btnGreen.setOnClickListener {
                txtCount.setBackgroundColor(resources.getColor(R.color.green, null))
                curColor = "green"
            }
        }
    }

    private fun reStoreValue() {
        val count = sharedPreferences.getInt("count", -1)
        curColor = sharedPreferences.getString("color","").toString()
        if (count!=-1 && curColor != ""){
            binding.apply {
                txtCount.text = count.toString()
                when(curColor.lowercase()){
                    "black" -> txtCount.setBackgroundColor(resources.getColor(R.color.black, null))
                    "red" -> txtCount.setBackgroundColor(resources.getColor(R.color.red,null))
                    "blue" -> txtCount.setBackgroundColor(resources.getColor(R.color.blue,null))
                    "green" -> txtCount.setBackgroundColor(resources.getColor(R.color.green,null))
                    else -> {}
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val editor= sharedPreferences.edit()
        editor.putInt("count", binding.txtCount.text.toString().toInt())
        editor.putString("color", curColor)
        editor.apply()
    }
}