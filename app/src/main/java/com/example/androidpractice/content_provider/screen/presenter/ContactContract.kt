package com.example.androidpractice.content_provider.screen.presenter

import android.content.Context
import com.example.androidpractice.content_provider.data.model.Contact

interface ContactContract {
    interface Presenter{
        fun getContacts(context: Context)
    }

    interface View{
        fun onGetContactSuccess(data: List<Contact>)
        fun onGetContactError(error: String)
    }

}