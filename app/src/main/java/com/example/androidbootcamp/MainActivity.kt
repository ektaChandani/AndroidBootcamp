package com.example.androidbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import java.util.concurrent.Executors

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
                    MainActivity.BUTTON_CLICKED_KEY,
                    MainActivity.ROOM_DEMO_BTN
                )
            )
        }

        addDummySqliteDemoBtn.setOnClickListener {
            insertDataInDBUsingRoom()
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_LONG).show()
        }
    }

    private fun insertDataInDBUsingRoom() {
        val database = RoomDatabaseBuilder.getInstance(this)

        Executors.newSingleThreadExecutor().execute {
            database.employeeDao().insertEmployeeDetails(
                EmployeeData(
                    name = "Rishabh",
                    contact = "1234567890",
                    address = "Noida"
                )
            )
            database.employeeDao().insertEmployeeDetails(
                EmployeeData(
                    name = "SHIKHA",
                    contact = "923651489",
                    address = "Lucknow"
                )
            )
            database.employeeDao().insertEmployeeDetails(
                EmployeeData(
                    name = "SANDEEP",
                    contact = "8299882484",
                    address = "Lucknow"
                )
            )

        }
    }
    companion object {
        const val BUTTON_CLICKED_KEY = "BUTTON_CLICKED"
        const val ROOM_DEMO_BTN = "ROOM_DEMO_BTN"
    }
}