package com.example.androidpractice

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityDrawableExampleBinding

class DrawableExampleActivity : AppCompatActivity() {
    private val binding: ActivityDrawableExampleBinding by lazy {
        ActivityDrawableExampleBinding.inflate(layoutInflater)
    }
    private var score1 = 0
    private var score2 = 0
    private var mode="Day mode"

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            btnMinus1.setOnClickListener {
                val currentScore = txtScore1.text.toString().toInt()
                if (currentScore > 0) {
                    txtScore1.text = (currentScore - 1).toString()
                    score1 = currentScore - 1
                }
            }
            btnPlus1.setOnClickListener {
                val currentScore = txtScore1.text.toString().toInt()
                txtScore1.text = (currentScore + 1).toString()
                score1 = currentScore + 1
            }
            btnMinus2.setOnClickListener {
                val currentScore = txtScore2.text.toString().toInt()
                if (currentScore > 0) {
                    txtScore2.text = (currentScore - 1).toString()
                    score2 = currentScore - 1
                }
            }
            btnPlus2.setOnClickListener {
                val currentScore = txtScore2.text.toString().toInt()
                txtScore2.text = (currentScore + 1).toString()
                score2 = currentScore + 1
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_drawble_example, menu)
        updateMenuTitle(menu!!.findItem(R.id.action_toggle_theme),
            if (mode.equals("Day mode")) "Night mode" else "Day mode")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (mode) {
            "Day mode" -> {
                updateMenuTitle(item, mode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                Toast.makeText(this, "Night mode is activated", Toast.LENGTH_SHORT).show()
                mode = "Night mode"
                true
            }
            "Night mode" -> {
                updateMenuTitle(item, mode)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                Toast.makeText(this, "Day mode is activated", Toast.LENGTH_SHORT).show()
                mode = "Day mode"
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMenuTitle(item: MenuItem, title: String) {
        item.title = title
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SCORE1 , score1)
        outState.putInt(SCORE2, score2)
        outState.putString(MODE, mode)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        score1 = savedInstanceState.getInt(SCORE1)
        score2 = savedInstanceState.getInt(SCORE2)
        binding.txtScore1.text = score1.toString()
        binding.txtScore2.text = score2.toString()
        mode = savedInstanceState.getString(MODE).toString()
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object{
        const val SCORE1 = "SCORE1"
        const val SCORE2 = "SCORE2"
        const val MODE = "MODE"
    }
}