package com.example.androidpractice.menu_example

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ItemDessertBinding

class DessertAdapter(private var list: List<Dessert>, val activity: Activity) :
    RecyclerView.Adapter<DessertAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemDessertBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(dessert: Dessert) {
            binding.apply {
                imgDessert.setImageResource(dessert.image)
                txtDessert.text = dessert.description
            }
        }

        override fun onClick(p0: View?) {
            val intent = Intent(activity, OrderDessertActivity::class.java)
            intent.putExtra("Dessert", list[adapterPosition])
            activity.startActivity(intent)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Dessert>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDessertBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}