package com.example.androidbootcamp

import androidx.room.Database
import androidx.room.RoomDatabase


// Entity means a row
@Database(entities = [EmployeeData::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun employeeDao(): RoomEmployeeDoa
}