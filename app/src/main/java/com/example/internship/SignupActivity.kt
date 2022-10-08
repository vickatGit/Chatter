package com.example.internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.internship.ViewModels.SignupViewModel
import io.socket.client.IO
import java.util.*

class SignupActivity : AppCompatActivity() {
    
    private lateinit var userNameEdit:EditText
    private lateinit var passwordEdit:EditText
    private lateinit var createAccount:Button
    private lateinit var loginProcess:ProgressBar
    private lateinit var signupViewModel:SignupViewModel
    
    val socket= IO.socket("http://192.168.43.103:3000")
    private val serverPath: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        initialise()
        signupViewModel=ViewModelProvider(this).get(SignupViewModel::class.java)
        signupViewModel.initialiseRepo(this)
        createAccount.setOnClickListener {  
            val userName=userNameEdit.text.toString()
            val password=passwordEdit.text.toString()
            if(!userName.isEmpty() && !password.isEmpty()){
                val userId=userName + UUID.randomUUID()
                signupViewModel.createUser(userName,password,userId).observe(this, androidx.lifecycle.Observer {isUserCreated ->
                    if(isUserCreated)
                        startActivity(Intent(this,LoginActivity::class.java))
                    else
                        Toast.makeText(this,"Can't create User",Toast.LENGTH_SHORT).show()
                })
            }
        }
        

    }

    private fun initialise() {
        userNameEdit=findViewById(R.id.user_name_edit_signup)
        passwordEdit=findViewById(R.id.password_edit_signup)
        loginProcess=findViewById(R.id.progress)
        createAccount=findViewById(R.id.login)
    }

}