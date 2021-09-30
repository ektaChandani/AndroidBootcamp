package com.example.androidbootcamp.exercise30

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidbootcamp.DetailActivity
import com.example.androidbootcamp.R

class SignupActivity : AppCompatActivity() {
    private lateinit var etUserName: EditText
    private lateinit var etEmail:EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var etPassword:EditText
    private lateinit var btnData :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        viewInitializations()

        btnData= findViewById<Button>(R.id.bt_register)
        btnData.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java).putExtra("username" ,etUserName.text.toString())
                .putExtra("email" , etEmail.text.toString())
                .putExtra("password" , etPassword.text.toString())
                .putExtra("phonenumber" , etPhoneNumber.text.toString()))



            val username = etUserName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phonenumber = etPhoneNumber.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if(username.isEmpty()){
                etUserName.error = "Username Required"
                return@setOnClickListener

            }else if (email.isEmpty()){
                etEmail.error="Email Required"
                return@setOnClickListener
            }else if(phonenumber.isEmpty()){
                etPhoneNumber.error = "PhoneNumber Required"
                return@setOnClickListener

            } else if (password.isEmpty()) {
                etPassword.error = "PhoneNumber Required"
                return@setOnClickListener
            }else
            {
                Toast.makeText(this,"Signup Successful" , Toast.LENGTH_SHORT).show()
            }

        }




    }

    private fun viewInitializations() {
        etUserName = findViewById(R.id.et_username)
        etEmail = findViewById(R.id.et_emailid)
        etPhoneNumber = findViewById(R.id.et_phonenumber)
        etPassword = findViewById(R.id.et_password)

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }




    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



    }




