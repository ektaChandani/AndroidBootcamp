package com.example.androidbootcamp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidbootcamp.roomdb.RoomAppData
import com.example.androidbootcamp.roomdb.UserEntity

class ViewModel(app:Application):AndroidViewModel(app) {
    lateinit var allUsers:MutableLiveData<List<UserEntity>>

    init {

        allUsers = MutableLiveData()
        getAllUsers()
    }
    fun getAllUsersObservers():MutableLiveData<List<UserEntity>>{
        return allUsers
    }
    fun getAllUsers(){
        val userDao = RoomAppData.getAppDatabase((getApplication()))?.userDao()
        val list = userDao?.getAllUserInfo()
        allUsers.postValue(list)
    }
    fun insertUserInfo(entity: UserEntity){
        val userDao = RoomAppData.getAppDatabase(getApplication())?.userDao()
        userDao?.insertUser(entity)
        getAllUsers()
    }

    fun updateUserInfo(entity: UserEntity){
        val userDao = RoomAppData.getAppDatabase(getApplication())?.userDao()
        userDao?.updateUser(entity)
        getAllUsers()
    }
    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppData.getAppDatabase(getApplication())?.userDao()
        userDao?.deleteUser(entity)
        getAllUsers()
    }
}