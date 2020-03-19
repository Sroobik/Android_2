package com.example.android_2.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android_2.data.database.dao.RecyclerDao
import com.example.android_2.model.RecyclerItemData

@Database(
    entities = [
        RecyclerItemData::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase(){

    abstract fun recyclerDao(): RecyclerDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MyDatabase? = null

        const val MY_DATABASE = "my_database"

        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

                val instance = Room.databaseBuilder(
                    context,
                    MyDatabase::class.java,
                    MY_DATABASE
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance

        }
    }
}