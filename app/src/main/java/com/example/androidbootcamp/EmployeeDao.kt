package com.example.androidbootcamp

import androidx.room.*

// @annotation_name are inbuilt annontations
// of Androidx Room

@Dao
interface RoomEmployeeDoa {

    @Query("SELECT * FROM emp_table")
    fun getAllEmployeeDetails(): List<EmployeeData>

    @Insert
    fun insertEmployeeDetails(employee: EmployeeData)

    @Update
    fun updateEmployeeDetails(employee: EmployeeData)

    @Delete
    fun deleteEmployeeDetails(employee: EmployeeData)
}