package com.example.android_2.data

import android.content.Context

class SharedPreferences(context: Context){

    companion object {
        const val MY_PREF = "my_pref_android"
        const val APP_OPEN_COUNT = "app_open_count"
        const val LAST_OPEN_TIME = "last_open_time"
    }
    val preferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)

    fun getAppOpenCount(): Int{
        return preferences.getInt(APP_OPEN_COUNT, 0)
    }

    fun setAppOpenCount(count: Int){
        preferences.edit().putInt(APP_OPEN_COUNT, count).apply()
    }

    var lastOpenTime: Long
        @Synchronized get() = preferences.getLong(LAST_OPEN_TIME, 0)
        @Synchronized set(value) = preferences.edit().putLong(LAST_OPEN_TIME, value).apply()
}