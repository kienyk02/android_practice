package com.example.androidpractice.search_book_author

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.loader.content.AsyncTaskLoader
import java.net.HttpURLConnection
import java.net.URL

data class ApiResponse(val response: String?, val error: String?)

class ApiAsyncTaskLoader(context: Context, private val args: Bundle?) : AsyncTaskLoader<ApiResponse>(context) {

    override fun loadInBackground(): ApiResponse? {
        val urlString = args?.getString("apiUrl") ?: return ApiResponse(null, "URL is null")
        var urlConnection: HttpURLConnection? = null
        return try {
            val url = URL(urlString)
            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            val inputStream = urlConnection.inputStream
            val response = inputStream.bufferedReader().use { it.readText() }
            ApiResponse(response, null)
        } catch (e: Exception) {
            Log.e("ApiAsyncTaskLoader", "Error: ${e.message}", e)
            ApiResponse(null, e.message)
        } finally {
            urlConnection?.disconnect()
        }
    }

    override fun onStartLoading() {
        forceLoad()
    }
}
