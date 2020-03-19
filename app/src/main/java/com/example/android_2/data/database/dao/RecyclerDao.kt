package com.example.android_2.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android_2.model.RecyclerItemData

@Dao
interface RecyclerDao {

    @Query("SELECT * from recycler_table")
    fun getAllItem(): List<RecyclerItemData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: RecyclerItemData)

    @Query("DELETE FROM recycler_table")
    fun deleteAll()
}