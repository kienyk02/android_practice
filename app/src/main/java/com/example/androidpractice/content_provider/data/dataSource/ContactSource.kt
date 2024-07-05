package com.example.androidpractice.content_provider.data.dataSource

import android.content.Context
import com.example.androidpractice.content_provider.data.model.Contact
import com.example.androidpractice.content_provider.screen.OnResultListener

interface ContactSource {
    fun getContacts(listener: OnResultListener<List<Contact>>, context: Context)
}