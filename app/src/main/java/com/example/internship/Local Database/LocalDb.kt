package com.example.internship.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.internship.ChatActivity

@Database(entities=[UserEntity::class,FriendEntity::class,ChatEntity::class],views=[],version=1,exportSchema = false)
abstract class LocalDb : RoomDatabase() {
    abstract fun getLocalDAO():LocalDbDAO
    companion object{
        @Volatile
        var LocalDatabse:LocalDb?=null
        @Synchronized
        fun getInstance(context:Context): LocalDb? {
            if(LocalDatabse==null){
                LocalDatabse= Room.databaseBuilder(context,LocalDb::class.java,"ChatAppDatabase").build()
                return LocalDatabse
            }
            return LocalDatabse
        }
    }
}