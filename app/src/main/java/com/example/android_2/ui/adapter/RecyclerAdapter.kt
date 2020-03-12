package com.example.android_2.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_2.R
import com.example.android_2.model.RecyclerItemData
import com.example.android_2.ui.main.common.extension.inflate

class RecyclerAdapter(private val itemList: List<RecyclerItemData>) :
    RecyclerView.Adapter<ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflatedView = parent.inflate(R.layout.recycler_item, false)
        return ItemHolder(inflatedView)
    }

    override fun getItemCount(): Int = itemList.size


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val title = itemList[position]
        holder.bindTitle(title.title)
    }
}