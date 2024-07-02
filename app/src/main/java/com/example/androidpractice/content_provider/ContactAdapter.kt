package com.example.androidpractice.content_provider

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemContactBinding

class ContactAdapter(private var list: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.txtName.text = contact.name
            binding.txtPhone.text = contact.phone
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Contact>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}