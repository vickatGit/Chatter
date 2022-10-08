package com.example.internship.Models

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val userName:String, val password:String, @PrimaryKey val userId:String) : Parcelable
