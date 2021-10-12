package com.example.androidbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // insertDataInDBUsingSQLite()
        val addDummySqliteDemoBtn:Button = findViewById(R.id.addDummyRoomDataBtn)
        val sqliteDemoBtn:Button = findViewById(R.id.sqliteDemoBtn)
        sqliteDemoBtn.setOnClickListener {
            startActivity(
                Intent(this, DatabaseActivity::class.java).putExtra(
                    BUTTON_CLICKED_KEY,
                    SQLITE_DEMO_BTN
                )
            )
        }

        addDummySqliteDemoBtn.setOnClickListener {
            insertDataInDBUsingSQLite()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }
    }

    private fun insertDataInDBUsingSQLite() {

        val databaseManager =
            SQLiteDatabaseManager(this)

        // insert data in DB
        databaseManager.insertValue(
            EmployeeDataClass(
                name = "ekta",
                contact = "9823651489",
                address = "Kolkata"
            )
        )
        databaseManager.insertValue(
            EmployeeDataClass(
                name = "Sandeep",
                contact = "9123654789",
                address = "Lucknow"
            )
        )
        databaseManager.insertValue(
            EmployeeDataClass(
                name = "Rita",
                contact = "9236412365",
                address = "Mumbai"
            )
        )
    }


//    private fun insertDataInDBUsingSQLite(key: String, value: String) {
//
//        val databaseManager =
//            SQLiteDatabaseManager(this)
//
//        // insert data in DB
//        databaseManager.insertValue(
//            EmployeeDataClass(
//                name = value,
//                contact = key,
//                address = "New Delhi"
//            )
//        )
//    }

    companion object {
        const val BUTTON_CLICKED_KEY = "BUTTON_CLICKED"
        const val SQLITE_DEMO_BTN = "SQLITE_DEMO_BTN"

        const val PERMISSIONS_REQUEST_READ_CONTACTS = 100
    }
}