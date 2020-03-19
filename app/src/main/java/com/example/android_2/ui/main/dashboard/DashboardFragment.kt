package com.example.android_2.ui.main.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_2.R
import com.example.android_2.data.database.db.MyDatabase
import com.example.android_2.data.repository.RecyclerRepository
import com.example.android_2.databinding.FragmentDashboardBinding
import com.example.android_2.model.RecyclerItemData
import com.example.android_2.ui.adapter.RecyclerAdapter

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var binding: FragmentDashboardBinding
    private lateinit var adapter: RecyclerAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var repository: RecyclerRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context?.let {
            repository = RecyclerRepository(it)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashboardBinding.inflate(layoutInflater, container, false)

        binding.textDashboard.text = "Testovaci recycler"


        binding.addNew.setOnClickListener {
            val new = RecyclerItemData(0,"testaa", "Dlhy text")
            repository.addNewItem(new)
            adapter.addItem(new)
        }

        linearLayoutManager = LinearLayoutManager(context)
        binding.dashboardRecycler.layoutManager = linearLayoutManager


        val itemList = repository.getAll().toMutableList()
        adapter = RecyclerAdapter(itemList)
        binding.dashboardRecycler.adapter = adapter
        return binding.root
    }
}
