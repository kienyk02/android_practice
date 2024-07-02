package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.broadcasts_example.BroadCastsActivity
import com.example.androidpractice.content_provider.ContentProviderActivity
import com.example.androidpractice.databinding.ActivityMainBinding
import com.example.androidpractice.fragment_example.FragmentExample1Activity
import com.example.androidpractice.intent_example.IntentExampleActivity
import com.example.androidpractice.internet_connection.InternetConnectionActivity
import com.example.androidpractice.menu_example.MenuExampleActivity
import com.example.androidpractice.navigation_example.NavigationExampleActivity
import com.example.androidpractice.recycleview_example.RecycleViewExampleActivity
import com.example.androidpractice.search_book_author.SearchBookActivity
import com.example.androidpractice.sqlite_example.SqliteActivity

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

            btnNavigationExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, NavigationExampleActivity::class.java))
            }

            btnRecycleViewExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, RecycleViewExampleActivity::class.java))
            }

            btnExcutorExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, ExecutorExampleActivity::class.java))
            }

            btnInternetConnectionExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, InternetConnectionActivity::class.java))
            }

            btnSearchBookAuthor.setOnClickListener {
                startActivity(Intent(this@MainActivity, SearchBookActivity::class.java))
            }

            btnBroadCasts.setOnClickListener {
                startActivity(Intent(this@MainActivity, BroadCastsActivity::class.java))
            }

            btnSharedPreferences.setOnClickListener {
                startActivity(Intent(this@MainActivity, SharedPreferencesActivity::class.java))
            }

            btnSqliteExample.setOnClickListener {
                startActivity(Intent(this@MainActivity, SqliteActivity::class.java))
            }

            btnContentProvider.setOnClickListener {
                startActivity(Intent(this@MainActivity, ContentProviderActivity::class.java))
            }
        }
    }

}