package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityMainBinding
import com.example.androidpractice.fragment_example.FragmentExample1Activity
import com.example.androidpractice.intent_example.IntentExampleActivity
import com.example.androidpractice.menu_example.MenuExampleActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnIntentExample.setOnClickListener{
                startActivity(Intent(this@MainActivity, IntentExampleActivity::class.java))
            }

            btnFragmentExample1.setOnClickListener {
                startActivity(Intent(this@MainActivity, FragmentExample1Activity::class.java))
            }

            btnDrawableExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, DrawableExampleActivity::class.java))
            }

            btnMenuExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, MenuExampleActivity::class.java))
            }
        }
    }

}