package com.example.android_2.ui.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class ItemHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

    private var view: View = v


    init {
        v.setOnClickListener(this)
    }


    fun bindTitle(title: String) {
        view.recycler_item_title.text = title
    }

    override fun onClick(v: View) {
        Log.d("RecyclerView", "CLICK!")
    }


}