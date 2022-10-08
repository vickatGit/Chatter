package com.example.internship.ViewModels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.internship.Local.UserEntity
import com.example.internship.Repository.UserLoginSignupRepo

class SignupViewModel: ViewModel() {

    private lateinit var signupRepo:UserLoginSignupRepo
    fun initialiseRepo(context: Context){
        signupRepo= UserLoginSignupRepo(context)
    }
    fun createUser(userName: String, password: String, userId: String): MutableLiveData<Boolean> {
        return signupRepo.createUser(UserEntity(userName,password,userId))
    }
}