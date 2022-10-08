package com.example.internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import com.example.internship.ViewModels.LoginViewModel
import java.util.*

class LoginActivity : AppCompatActivity() {

    private lateinit var userNameEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var login: Button
    private lateinit var loginProcess: ProgressBar
    private lateinit var loginViewModel: LoginViewModel

    companion object{
        val USER_PASSER_BRIDGE:String="user_passer"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialise()
        loginViewModel=ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.initialiseRepo(this)

        loginViewModel.isUserExist().observe(this, androidx.lifecycle.Observer {user ->
            if(user!=null) {
                Log.d("TAG", "onCreate:user $user")
                val intent=Intent(this,ChatActivity::class.java)
                startActivity(intent)
                loginProcess.visibility= View.INVISIBLE
            }
            else {
                val intent=Intent(this,SignupActivity::class.java)
                startActivity(intent)
                loginProcess.visibility= View.INVISIBLE
            }
        })


    }

    private fun initialise() {
        userNameEdit=findViewById(R.id.user_name_edit_login)
        passwordEdit=findViewById(R.id.password_edit_login)
        loginProcess=findViewById(R.id.progress)
        login=findViewById(R.id.login)
    }
}