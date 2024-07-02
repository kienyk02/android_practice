package com.example.androidpractice.internet_connection

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

object FetchApi {
    val url = "http://192.168.2.108:5000/"

    fun getData(endPoint: String): String {
        val newUrl = url + endPoint
        val connection = URL(newUrl).openConnection() as HttpURLConnection
        addHeader(connection)
        connection.apply {
            requestMethod = "GET"
            doInput = true
            return readResponse(this)
        }
    }

    fun postData(endPoint: String, body: String): String {
        val newUrl = url + endPoint
        val connection = URL(newUrl).openConnection() as HttpURLConnection
        addHeader(connection)
        connection.apply {
            requestMethod = "POST"
            doInput = true
            writeData(this, body)
            return readResponse(this)
        }
    }

    private fun writeData(connection: HttpURLConnection, body: String) {
        val outputStreamWriter = OutputStreamWriter(connection.outputStream)
        outputStreamWriter.write(body)
        outputStreamWriter.flush()
        outputStreamWriter.close()
    }

    private fun readResponse(connection: HttpURLConnection): String {
        val response = StringBuilder()
        val inputStreamReader = InputStreamReader(connection.inputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            response.append(line)
        }
        bufferedReader.close()
        return response.toString()
    }

    private fun addHeader(connection: HttpURLConnection) {
        connection.setRequestProperty("content-type", "application/json")
    }
}