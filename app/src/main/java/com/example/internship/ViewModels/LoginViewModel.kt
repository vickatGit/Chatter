package com.example.internship.ViewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.internship.Local.UserEntity
import com.example.internship.Models.User
import com.example.internship.Repository.UserLoginSignupRepo

class LoginViewModel : ViewModel() {
    private lateinit var loginRepo: UserLoginSignupRepo
    fun initialiseRepo(context: Context){
        loginRepo= UserLoginSignupRepo(context)
    }

    fun isUserExist(): MutableLiveData<List<UserEntity>?> {
        return loginRepo.isUserExist()
    }
}