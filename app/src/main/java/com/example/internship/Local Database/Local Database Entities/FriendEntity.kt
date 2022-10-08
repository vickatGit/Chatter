package com.example.internship.Local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FriendEntity(val userName:String, @PrimaryKey val userId:String)
