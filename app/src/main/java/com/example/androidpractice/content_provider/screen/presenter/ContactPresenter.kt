package com.example.androidpractice.content_provider.screen.presenter

import android.content.Context
import com.example.androidpractice.content_provider.data.model.Contact
import com.example.androidpractice.content_provider.data.repository.ContactRepository
import com.example.androidpractice.content_provider.screen.OnResultListener

class ContactPresenter(private val contactRepository: ContactRepository) :
    ContactContract.Presenter {
    private var view: ContactContract.View? = null

    fun setView(view: ContactContract.View) {
        this.view = view
    }

    override fun getContacts(context: Context) {
        val listener = object : OnResultListener<List<Contact>> {
            override fun onSuccess(data: List<Contact>) {
                view?.onGetContactSuccess(data)
            }

            override fun onError(error: String) {
                view?.onGetContactError(error)
            }
        }
        contactRepository.getContacts(listener, context)
    }
}