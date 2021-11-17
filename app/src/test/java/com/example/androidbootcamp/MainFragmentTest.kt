package com.example.androidbootcamp

import android.content.Context
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MainFragmentTest {
    lateinit var mockeditemclick :MainFragment
    @Mock
    lateinit var context: Context



    @Before
    fun setup(){
//        context = Instrumentation
    }
}