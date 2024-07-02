package com.example.androidpractice.sqlite_example

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivitySqliteBinding

class SqliteActivity : AppCompatActivity() {
    private val binding: ActivitySqliteBinding by lazy {
        ActivitySqliteBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val db= DBHelper(this)
        binding.apply {
            btnGet.setOnClickListener {
                db.get()
            }
            btnAdd.setOnClickListener {
                db.add(User(null, "User 1", 20))
            }
            btnUpdate.setOnClickListener {
                db.update(User(1, "Kien vip", 22))
            }
            btnDelete.setOnClickListener {
                db.delete(1)
            }
        }

    }
}