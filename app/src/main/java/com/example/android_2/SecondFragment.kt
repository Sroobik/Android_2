package com.example.android_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_2.databinding.FragmentDashboardBinding
import com.example.android_2.databinding.FragmentSecondBinding
import com.example.android_2.ui.adapter.RecyclerAdapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding

    companion object {
        const val ARG_1 = "product"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)

        val text = arguments?.getString(ARG_1, "") ?: ""
        val boolean = arguments?.getBoolean("druhy") ?: false

        if (boolean) {
            binding.textviewSecond.text = text
        } else {
            binding.textviewSecond.text = "Error"
        }

        return binding.root
    }

}
