package com.example.internship.Local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChatEntity(@PrimaryKey val from:String, val to:String)
