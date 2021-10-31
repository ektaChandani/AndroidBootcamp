package com.example.androidbootcamp.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class],version = 1)
abstract class RoomAppData : RoomDatabase (){

    abstract fun userDao():UserDao?

    companion object{
        private var INSTANCE:RoomAppData?=null

        fun getAppDatabase(context: Context):RoomAppData?{
            if (INSTANCE ==null){
                INSTANCE= Room.databaseBuilder<RoomAppData>(
                    context.applicationContext,RoomAppData::class.java , "AppDB")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}