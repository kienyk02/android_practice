package com.example.androidpractice.content_provider.data.repository

import android.content.Context
import com.example.androidpractice.content_provider.data.dataSource.ContactSource
import com.example.androidpractice.content_provider.data.model.Contact
import com.example.androidpractice.content_provider.screen.OnResultListener

class ContactRepositoryImpl(private val contactSource: ContactSource): ContactRepository {
    override fun getContacts(listener: OnResultListener<List<Contact>>, context: Context) {
        contactSource.getContacts(listener, context)
    }
}