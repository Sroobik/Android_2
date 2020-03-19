package com.example.android_2.ui.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.android_2.model.Post
import kotlinx.android.synthetic.main.retrofit_item.view.*

class RetrofitItem(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

    private var view: View = v


    init {
        v.setOnClickListener(this)
    }


    fun bind(item: Post) {
        view.retrofit_title.text = item.title
    }

    override fun onClick(v: View) {
        Log.d("RecyclerView", "CLICK!")
    }


}