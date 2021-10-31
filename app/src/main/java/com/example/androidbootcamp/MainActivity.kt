package com.example.androidbootcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.androidbootcamp.roomdb.UserEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_item.*


class MainActivity :AppCompatActivity() ,RecyclerViewAdapter. RowClickListener{

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcv_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity)
            adapter = recyclerViewAdapter
            val divider = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(divider)
        }
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        viewModel.getAllUsersObservers().observe(this , Observer {
            recyclerViewAdapter.setListData(ArrayList(it))
            recyclerViewAdapter.notifyDataSetChanged()
        })
        btn_save.setOnClickListener {
            val name = et_name.text.toString()
            val email=et_email.text.toString()
            val phone = phoneInput.text.toString()
            if (btn_save.text.equals("Save")){
                val user = UserEntity(0 , name , email,phone)
                viewModel.insertUserInfo(user)
        }else{
            val user = UserEntity(et_name.getTag(et_name.id).toString().toInt() , name , email,phone)
                viewModel.updateUserInfo(user)
                btn_save.setText("Save")
            }
            et_name.setText("")
            et_email.setText("")
        }

    }


    override fun onDeleteUserClick(user: UserEntity) {
        viewModel.deleteUserInfo(user)

    }

    override fun onItemClickListener(user: UserEntity) {
        et_name.setText(user.name)
        et_email.setText(user.email)
        phoneInput.setText(user.phone)
        et_name.setTag(et_name.id , user.id)
        btn_save.setText("Update")
    }
}