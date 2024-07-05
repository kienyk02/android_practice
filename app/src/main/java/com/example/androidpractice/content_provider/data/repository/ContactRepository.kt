package com.example.androidpractice.content_provider.data.repository

import android.content.Context
import com.example.androidpractice.content_provider.data.model.Contact
import com.example.androidpractice.content_provider.screen.OnResultListener

interface ContactRepository {
    fun getContacts(listener: OnResultListener<List<Contact>>, context: Context)
}