package com.example.android_2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_2.R
import com.example.android_2.databinding.FragmentDashboardBinding
import com.example.android_2.ui.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var adapter: RecyclerAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    val itemList = listOf("TEXT1", "TEXT2", "TEXT3")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)

        binding.textDashboard.text = "Testovaci recycler"

        linearLayoutManager = LinearLayoutManager(context)
        binding.dashboardRecycler.layoutManager = linearLayoutManager

        adapter = RecyclerAdapter(itemList)
        binding.dashboardRecycler.adapter = adapter
        return binding.root
    }


}
