package com.example.android2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.android2.R
import com.example.android2.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)

        val text = binding.editText.text

        binding.message.text = "text"

        binding.button.setOnClickListener {
            Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        }

        binding.editText.doAfterTextChanged { text ->
            binding.message.text = text.toString()
        }
        return binding.root
    }

    /*  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          message.text = "alojz"
      }*/
}
