package com.example.internship.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.internship.Models.User

@Dao
interface LocalDbDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertUser(user:UserEntity)


    @Query("SELECT * FROM UserEntity")
    suspend fun getUser():List<UserEntity>
}