package com.example.usersinfo.localdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoUser {

    @Insert
    suspend fun addUser(info: Information)

    @Query("SELECT * FROM Information")
     fun getAllUsers():  LiveData<List<Information>>
}