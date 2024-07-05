package com.example.androidpractice.content_provider.data.dataSource

import android.content.Context
import android.provider.ContactsContract
import com.example.androidpractice.content_provider.data.model.Contact
import com.example.androidpractice.content_provider.screen.OnResultListener

class ContactSourceImpl : ContactSource {
    override fun getContacts(listener: OnResultListener<List<Contact>>, context: Context) {
        val contactList = ArrayList<Contact>()
        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )

        cursor?.let {
            if (cursor.count > 0) {
                val nameIndex =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                val phoneIndex =
                    cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                while (cursor.moveToNext()) {
                    val name = cursor.getString(nameIndex)
                    val phoneNumber = cursor.getString(phoneIndex)
                    contactList.add(Contact(name, phoneNumber))
                }
                listener.onSuccess(contactList)
            } else {
                listener.onError("No Contact!")
            }
            cursor.close()
        }
    }
}