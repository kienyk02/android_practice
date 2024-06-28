package com.example.androidpractice.intent_example

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.databinding.ActivityIntentExampleBinding

class IntentExampleActivity : AppCompatActivity() {
    private val binding: ActivityIntentExampleBinding by lazy {
        ActivityIntentExampleBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            btnOpenWebsite.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(edtUrl.text.toString())
                startActivity(intent)
            }

            btnOpenLocation.setOnClickListener {
                val gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(edtLocation.text.toString()))
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)

            }

            btnShareText.setOnClickListener {
                val intent = Intent(this@IntentExampleActivity, SecondActivity::class.java)
                intent.putExtra("shareText",edtText.text.toString())
                startActivity(intent)
            }
        }
    }
}