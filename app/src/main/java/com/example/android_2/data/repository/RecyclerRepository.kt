package com.example.android_2.data.repository

import android.content.Context
import com.example.android_2.data.database.dao.RecyclerDao
import com.example.android_2.data.database.db.MyDatabase
import com.example.android_2.model.RecyclerItemData

class RecyclerRepository(context: Context) {
    val recyclerDao = MyDatabase.getDatabase(context).recyclerDao()
    fun addNewItem(item: RecyclerItemData){
        recyclerDao.insert(item)
    }

    fun getAll(): List<RecyclerItemData>{
        return recyclerDao.getAllItem()
    }
}