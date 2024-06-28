package com.example.androidpractice.menu_example

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityMenuExampleBinding

class MenuExampleActivity : AppCompatActivity() {
    private val binding: ActivityMenuExampleBinding by lazy {
        ActivityMenuExampleBinding.inflate(layoutInflater)
    }

    private var listDessert = mutableListOf<Dessert>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.tbMenuExample)

        initData()
        val adapter = DessertAdapter(listDessert, this@MenuExampleActivity)
        binding.rvDesserts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvDesserts.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_drawble_example, menu)
        return true
    }

    private fun initData() {
        listDessert.add(
            Dessert(1, "Donut", "Donutrat la ngon", R.drawable.donut)
        )
        listDessert.add(
            Dessert(2, "Ice cream", "Ice cream rat la ngon", R.drawable.ice_cream)
        )
        listDessert.add(
            Dessert(3, "FroYo", "FroYo rat la ngon", R.drawable.froyo)
        )
    }

}