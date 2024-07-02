package com.example.androidpractice.recycleview_example

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityRecycleViewExampleBinding

class RecycleViewExampleActivity : AppCompatActivity() {
    private val binding: ActivityRecycleViewExampleBinding by lazy {
        ActivityRecycleViewExampleBinding.inflate(layoutInflater)
    }
    private var list = mutableListOf<String>()
    private var adapter: WordAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.tbRecycleViewExample)

        initData()
        val adapter = WordAdapter(list){ word ->
            Toast.makeText(this, word, Toast.LENGTH_SHORT).show()
        }
        binding.apply {
            recyclerView.layoutManager =
                LinearLayoutManager(this@RecycleViewExampleActivity, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter

            fab.setOnClickListener {
                openAddDialog()
            }
        }
    }

    private fun openAddDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_addword)

        val window = dialog.window
        if (window==null){
            return
        }
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val edtWord = dialog.findViewById<EditText>(R.id.edtWord)
        val btnAddWord = dialog.findViewById<Button>(R.id.btnAddWord)
        btnAddWord.setOnClickListener {
            val word = edtWord.text.toString()
            if (word.isEmpty()) {
                Toast.makeText(this, "Please enter word", Toast.LENGTH_SHORT).show()
            } else {
                list.add(word)
                adapter?.setData(list)
                Toast.makeText(this, "Add word success", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    private fun initData() {
        list.add("Word 1")
        list.add("Word 2")
        list.add("Word 3")
        list.add("Word 4")
        list.add("Word 5")
    }
}