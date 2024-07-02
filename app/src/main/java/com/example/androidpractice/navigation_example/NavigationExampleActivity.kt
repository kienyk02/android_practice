package com.example.androidpractice.navigation_example

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityNavigationExampleBinding
import com.google.android.material.tabs.TabLayoutMediator

class NavigationExampleActivity : AppCompatActivity() {
    private val binding: ActivityNavigationExampleBinding by lazy {
        ActivityNavigationExampleBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.tbNavigationExample)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val fragments = listOf(FirstFragment(), SecondFragment(), ThirdFragment())
        val pagerAdapter = MyPagerAdapter(this, fragments)
        binding.vpNavigationExample.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.vpNavigationExample){
            tab, position ->
            when(position){
                0 -> tab.text = "First"
                1 -> tab.text = "Second"
                2 -> tab.text = "Third"
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}