package com.example.androidpractice.fragment_example

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidpractice.MainActivity
import com.example.androidpractice.databinding.FragmentChoiceBinding


class ChoiceFragment : Fragment() {
    private lateinit var binding: FragmentChoiceBinding
    private var choice = ""
    private var onChoiceListener: OnChoiceListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChoiceBinding.inflate(inflater, container, false)

        binding.apply {
            rdYes.setOnClickListener {
                choice = "Yes"
                txtShow.text = "ARTICLE: Like"
                onChoiceListener?.onChoice(choice)
            }
            rdNo.setOnClickListener {
                choice = "No"
                txtShow.text = "ARTICLE: Thanks"
                onChoiceListener?.onChoice(choice)
            }
        }

        Toast.makeText(activity, "Choice fragment show", Toast.LENGTH_SHORT).show()
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        choice = arguments?.getString("Choice").toString()
        if (choice == "Yes") {
            binding.rdYes.isChecked = true
            binding.txtShow.text = "ARTICLE: Like"
        } else if (choice == "No") {
            binding.rdNo.isChecked = true
            binding.txtShow.text = "ARTICLE: Thanks"
        }
    }

    companion object {
        fun newInstance(choice: String): ChoiceFragment {
            val fragment = ChoiceFragment()
            val args = Bundle()
            args.putString("Choice", choice)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onChoiceListener = context as OnChoiceListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnChoiceListener")
        }
    }

    interface OnChoiceListener {
        fun onChoice(choice: String)
    }
}