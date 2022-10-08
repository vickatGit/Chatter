package com.example.internship.Repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.internship.Local.LocalDb
import com.example.internship.Local.UserEntity
import com.example.internship.Models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserLoginSignupRepo(context:Context) {

    private val localDb=LocalDb.getInstance(context.applicationContext)


    //MutableLiveData
    private var isUserCreated:MutableLiveData<Boolean> = MutableLiveData()
    private var isUserExist:MutableLiveData<List<UserEntity>?> = MutableLiveData()


    fun createUser(user: UserEntity): MutableLiveData<Boolean> {
        val creation=CoroutineScope(Dispatchers.IO).async {
            localDb?.getLocalDAO()?.InsertUser(user)
            isUserCreated.postValue(true)
        }
        return isUserCreated
    }

    fun isUserExist(): MutableLiveData<List<UserEntity>?> {
        CoroutineScope(Dispatchers.IO).launch {
            val user=localDb?.getLocalDAO()?.getUser()
            if(user!!.size>0) {
                isUserExist.postValue(user)
            }else{
                isUserExist.postValue(null)
            }
        }
        return isUserExist
    }
}