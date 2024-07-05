package com.example.androidpractice.content_provider.screen

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.content_provider.data.model.Contact
import com.example.androidpractice.content_provider.ContactAdapter
import com.example.androidpractice.content_provider.data.dataSource.ContactSourceImpl
import com.example.androidpractice.content_provider.data.repository.ContactRepositoryImpl
import com.example.androidpractice.content_provider.screen.presenter.ContactContract
import com.example.androidpractice.content_provider.screen.presenter.ContactPresenter
import com.example.androidpractice.databinding.ActivityContentProviderBinding


class ContentProviderActivity : AppCompatActivity(), ContactContract.View {
    private val binding: ActivityContentProviderBinding by lazy {
        ActivityContentProviderBinding.inflate(layoutInflater)
    }
    private val presenter = ContactPresenter(
        ContactRepositoryImpl(
            ContactSourceImpl()
        )
    )
    private val adapter = ContactAdapter(listOf())

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                presenter.getContacts(this)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.setView(this)
        binding.apply {
            rvContactList.layoutManager = LinearLayoutManager(
                this@ContentProviderActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            rvContactList.adapter = adapter
        }

        requestPermission.launch(Manifest.permission.READ_CONTACTS)
    }

    override fun onGetContactSuccess(data: List<Contact>) {
        adapter.setData(data)
    }

    override fun onGetContactError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}