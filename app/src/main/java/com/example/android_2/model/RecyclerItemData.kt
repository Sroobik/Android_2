package com.example.android_2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecyclerItemData(val title: String, val content: String, val image: Int): Parcelable