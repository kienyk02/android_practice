package com.example.androidpractice.internet_connection

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityInternetConnectionBinding
import org.json.JSONArray
import org.json.JSONObject
import java.util.concurrent.Executors

class InternetConnectionActivity : AppCompatActivity() {
    private val binding: ActivityInternetConnectionBinding by lazy {
        ActivityInternetConnectionBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnGet.setOnClickListener {
                onGetButtonClick()
            }
            btnPost.setOnClickListener {
                onPostButtonClick()
            }
        }
    }

    private fun onGetButtonClick(){
        val executors = Executors.newSingleThreadExecutor()
        executors.execute {
            val data = FetchApi.getData("getmodels")
            val model = parseData(data)
            runOnUiThread {
                binding.apply {
                    id.text = model.id.toString()
                    name.text = model.name
                    link.text = model.link
                    easy.text = model.easy.toString()
                    medium.text = model.medium.toString()
                    hard.text = model.hard.toString()
                    status.text = model.action
                }
            }
        }
    }

    private fun onPostButtonClick(){
        val executors = Executors.newSingleThreadExecutor()
        executors.execute {
            val modelObject = JSONObject()
            modelObject.put("id", 0)
            modelObject.put("name", "Model 1")
            modelObject.put("link", "https://www.google.com")
            modelObject.put("easy", 1)
            modelObject.put("medium", 2)
            modelObject.put("hard", 3)
            modelObject.put("action", "disable")
            val data = FetchApi.postData("savemodel/0", modelObject.toString())
            runOnUiThread {
                Toast.makeText(this, data.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun parseData(data: String): Model {
        val modelJsons = JSONArray(data)
        val modelJson = modelJsons.getJSONObject(0)
        return Model(
            modelJson.getInt("id"),
            modelJson.getString("name"),
            modelJson.getString("link"),
            modelJson.getInt("easy"),
            modelJson.getInt("medium"),
            modelJson.getInt("hard"),
            modelJson.getString("action")
        )
    }
}