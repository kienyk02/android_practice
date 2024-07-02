package com.example.androidpractice.recycleview_example

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemWordBinding

class WordAdapter(private var list: List<String>, val click: (String) -> Unit) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(word: String) {
            binding.textView.text = word
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWordBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list.get(position))
        holder.itemView.setOnClickListener {
            click(list[position])
        }
    }
}