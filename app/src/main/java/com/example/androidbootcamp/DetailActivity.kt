package com.example.androidbootcamp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class DetailActivity : AppCompatActivity() {

    lateinit var binding: DetailActivity
    private lateinit var textUserName: TextView
    private lateinit var textEmail: TextView
    private lateinit var textPhoneNumber: TextView
    private lateinit var textPassword: TextView
    private lateinit var urlView: EditText
    private lateinit var btnCamera: Button
    private lateinit var btnUrl: Button
    private lateinit var etUrl: EditText
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        textUserName = findViewById(R.id.tv_username)
        textEmail = findViewById(R.id.tv_email)
        textPhoneNumber = findViewById(R.id.tv_phone)
        textPassword = findViewById(R.id.tv_password)
        btnCamera = findViewById(R.id.bt_camera)
        btnUrl = findViewById(R.id.bt_url)
        etUrl = findViewById(R.id.et_url)


        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phonenumber = intent.getStringExtra("phonenumber")
        val password = intent.getStringExtra("password")
        textUserName.text = "username: $username"
        textEmail.text = "Email: $email"
        textPhoneNumber.text = "Phone Number: $phonenumber"
        textPassword.text = "Password :$password"

        btnUrl.setOnClickListener {
            if (etUrl.text.isNotBlank()) {
                // Parsing Url in Android URI
                val uri = Uri.parse("https://" + etUrl.text.toString())

                // create Implicit intent for browser
                val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
                startActivity(launchBrowser)
            } else {
                // show error
                urlView.error = "Enter URL"
            }
        }
        btnCamera.setOnClickListener {
            // It will check if permission is already
            // granted or not
            when (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA")) {
                PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "Camera permission already granted!", Toast.LENGTH_LONG)
                        .show()
                    Log.e("USER_PERMISSION", "PERMISSION_GRANTED")
                    //no need for permission, do the operation
                }
                // Permission not already given
                PackageManager.PERMISSION_DENIED -> {
                    Log.e("USER_PERMISSION", "PERMISSION_DENIED")
                    //ask for permission
                    askForPermission()
                }
            }
        }
    }

    private fun askForPermission() {
        val permissions = arrayOf("android.permission.CAMERA")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, 1001)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission granted
                Toast.makeText(this, "Camera permission granted!", Toast.LENGTH_LONG).show()
                Log.e("USER_PERMISSION", "PERMISSION_GRANTED ${permissions[0]}")
            } else {
                // permission denied
                Toast.makeText(
                    this,
                    "Camera permission denied. You can change this from settings.",
                    Toast.LENGTH_LONG
                )
                    .show()
                Log.e("USER_PERMISSION", "PERMISSION_DENIED ${permissions[0]}")
            }
        }
    }

}
