package com.example.internship.Local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(val userName:String, val password:String, @PrimaryKey val userId:String)
