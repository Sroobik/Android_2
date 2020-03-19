package com.example.android_2.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "recycler_table")
data class RecyclerItemData(@PrimaryKey(autoGenerate = true) val id: Int, @ColumnInfo val title: String,  @ColumnInfo val content: String): Parcelable