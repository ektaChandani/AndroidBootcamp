package com.example.androidbootcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.concurrent.Executors

class DatabaseActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.database_activity)

        // Get the intent data to check from
        // which button click the user is coming
        // in this activity
        val intent = intent
        BUTTON_CLICKED = intent.getStringExtra(MainActivity.BUTTON_CLICKED_KEY).toString()

        initialiseRecyclerView()

    }

    private fun initialiseRecyclerView() {
        recyclerView = findViewById(R.id.employeeDetailsRecyclerView)

        val linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        setupListFromRoom()
    }



    private fun setupListFromRoom() {
        val roomDatabaseBuilder = RoomDatabaseBuilder.getInstance(this)
        var employeeList: List<EmployeeData>

        Executors.newSingleThreadExecutor().execute {
            // get data from Database
            employeeList = roomDatabaseBuilder.employeeDao().getAllEmployeeDetails()

            recyclerView.apply {
                // Stuff that updates the UI
                runOnUiThread {
                    customAdapter =
                        CustomAdapter(
                            this@DatabaseActivity,
                            employeeList as ArrayList<EmployeeData>
                        )
                    recyclerView.adapter = customAdapter
                    customAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    companion object {
        lateinit var BUTTON_CLICKED: String
    }
}