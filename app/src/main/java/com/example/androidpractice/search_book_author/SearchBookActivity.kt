package com.example.androidpractice.search_book_author

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivitySearchBookBinding
import org.json.JSONObject
import java.io.File

class SearchBookActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<ApiResponse> {
    private val binding: ActivitySearchBookBinding by lazy {
        ActivitySearchBookBinding.inflate(layoutInflater)
    }
    private val LOADER_ID = 1
    private val baseURL = "https://www.googleapis.com/books/v1/volumes?q="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            val apiUrl = baseURL + binding.editText.text.toString()
            val bundle = Bundle().apply {
                putString("apiUrl", apiUrl)
            }
            LoaderManager.getInstance(this).restartLoader(LOADER_ID, bundle, this)
        }
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<ApiResponse> {
        return ApiAsyncTaskLoader(this, args)
    }

    override fun onLoadFinished(loader: Loader<ApiResponse>, data: ApiResponse?) {
        data?.response?.let {
            val bookObject = JSONObject(it)
                .getJSONArray("items")
                .getJSONObject(0)
                .getJSONObject("volumeInfo")
            val bookTitle = bookObject.getString("title")
            val authors = bookObject.getJSONArray("authors").toString()
            binding.txtName.text = bookTitle
            binding.txtAuthors.text = authors
        }
        data?.error?.let {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    override fun onLoaderReset(loader: Loader<ApiResponse>) {
    }
}