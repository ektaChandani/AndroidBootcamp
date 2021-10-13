package com.example.androidbootcamp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.ProgressBar
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var customAdapter:AdapterClass
    var isScrolling:Boolean = false
    val datatosend = ArrayList<CustomData>()

    @SuppressLint("UseSupportActionBar")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Custom Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = "Orders"
        toolbar.setTitleTextColor(Color.WHITE)
        setActionBar(toolbar)

        // add data in recycler view
        datatosend.addAll(CustomData.getData())


        val recyclerView = findViewById<RecyclerView>(R.id.rv_list)

        // attach adapter
        customAdapter = AdapterClass(datatosend)
        recyclerView.adapter = customAdapter

        // Set layout for RecyclerView
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        //Paging

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){

            //Checks if scrolling happened or not
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true
                }

            }

            //Paging implementation
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val currentItems:Int = linearLayoutManager.childCount
                val totalItems:Int = linearLayoutManager.itemCount
                val scrollOutItems:Int = linearLayoutManager.findFirstVisibleItemPosition()
                if (isScrolling && (currentItems + scrollOutItems == totalItems))
                {
                    isScrolling = false
                    Log.i("last", "Lastpage")
                    fetchData()
                }
            }
        })
    }
    //Fetches data after reaching to last element
    private fun fetchData() {
        val progressBar = findViewById<ProgressBar>(R.id.progress)
        progressBar.visibility = View.VISIBLE
        // Use
        val handler = Handler()
        handler.postDelayed({
            for (i in 1..5) {
                datatosend.add(
                    CustomData.getCustomData()

                )
                customAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
        }, 2000)
    }
}
