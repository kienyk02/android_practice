package com.example.androidpractice.fragment_example

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractice.R
import com.example.androidpractice.databinding.ActivityFragmentExample1Binding

class FragmentExample1Activity : AppCompatActivity(), ChoiceFragment.OnChoiceListener {
    private val binding: ActivityFragmentExample1Binding by lazy {
        ActivityFragmentExample1Binding.inflate(layoutInflater)
    }
    private var choice = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            btnToggle.setOnClickListener {
                if (btnToggle.text.toString().equals("open",ignoreCase = true)){
                    addChoiceFragment()
                    btnToggle.text = "close"
                }else{
                    removeChoiceFragment()
                    btnToggle.text = "open"
                }
            }
        }
    }

    private fun addChoiceFragment() {
        val choiceFragment = ChoiceFragment.newInstance(choice)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction
            .add(R.id.fragment_choice_container, choiceFragment)
            .commit()
    }

    private fun removeChoiceFragment() {
        val choiceFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_choice_container) as ChoiceFragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction
            .remove(choiceFragment)
            .commit()
    }

    override fun onChoice(choice: String) {
        this.choice = choice
    }
}