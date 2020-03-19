package com.example.android_2.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_2.R
import com.example.android_2.model.Post
import com.example.android_2.utils.inflate

class RetrofitAdapter(private val itemList: List<Post>) :
    RecyclerView.Adapter<RetrofitItem>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitItem {
        val inflatedView = parent.inflate(R.layout.retrofit_item, false)
        return RetrofitItem(inflatedView)
    }

    override fun getItemCount(): Int = itemList.size


    override fun onBindViewHolder(holder: RetrofitItem, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }
}