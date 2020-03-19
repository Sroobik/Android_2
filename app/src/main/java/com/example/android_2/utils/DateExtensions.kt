package com.example.android_2.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.getCompleteDate(): String {
    val s = SimpleDateFormat("dd.MM.yyyy - HH.mm.ss", Locale.getDefault())
    return s.format(Date(this))
}