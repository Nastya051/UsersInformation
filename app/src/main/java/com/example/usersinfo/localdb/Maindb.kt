package com.example.usersinfo.localdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Information::class], version = 2, exportSchema = true)
abstract class Maindb : RoomDatabase() {
    abstract fun getDao(): DaoUser

    companion object{
        fun getdb(context: Context): Maindb{
            return Room.databaseBuilder(context.applicationContext, Maindb::class.java, "info.db")
                .fallbackToDestructiveMigration().build()
        }
    }
}