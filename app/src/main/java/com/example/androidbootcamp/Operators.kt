package com.example.androidbootcamp

import android.util.Log
import com.example.androidbootcamp.data.User
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*
import java.util.concurrent.TimeUnit

val mList = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12)
val arrayNum= arrayOf(1,2,3,4,5,6,7,8,9,10,11,12)
val arrayNum1= arrayOf(10,20,30,40,50,60,70,80,90,100,110,120)
val mUserList = mutableListOf<User>(
    User(1,"ekta" , 25),
    User(2,"danny" , 26),
    User(3,"shweta" , 27),
    User(4,"sunita" , 28),
    User(5,"akanksha" , 29),
    User(6,"shreya" , 30),


)





    fun justOperator(){

        val observable = Observable.just(1 , 2 , 3 , 4 , 5 , 6 ,7 , 8 , 9 , 10 )

        val observer = object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {
                Log.d(MainActivity.TAG, "onSubscribe")
            }

            override fun onNext(t: Int?) {
                Log.d(MainActivity.TAG, "onNext : $t")
            }

            override fun onError(e: Throwable?) {
                Log.d(MainActivity.TAG, "onError ${e.toString()}")
            }

            override fun onComplete() {
                Log.d(MainActivity.TAG, "onComplete")
            }

        }

        observable.subscribe(observer)

    }

    fun fromOperator(){
        val observable=Observable.fromArray(arrayNum , arrayNum1)
        val observer = object :Observer<Array<Int>>{
            override fun onSubscribe(d: Disposable?) {
                Log.d(MainActivity.TAG, "onSubscribe")
            }

            override fun onNext(t: Array<Int>?) {
                Log.d(MainActivity.TAG, "onNext : ${Arrays.toString(t)}")
            }

            override fun onError(e: Throwable?) {
                Log.d(MainActivity.TAG, "onError ${e.toString()}")
            }

            override fun onComplete() {
                Log.d(MainActivity.TAG, "onSubscribe")
            }

        }
        observable.subscribe(observer)
    }

fun fromIterableOperator(){
    val observable = Observable.fromIterable(mList)

    val observer = object :Observer<Int>{
        override fun onSubscribe(d: Disposable?) {
            Log.d(MainActivity.TAG, "onSubscribe")

        }

        override fun onNext(t: Int?) {
            Log.d(MainActivity.TAG, "onNext : $t")
        }

        override fun onError(e: Throwable?) {
            Log.d(MainActivity.TAG, "onError ${e.toString()}")
        }

        override fun onComplete() {
            Log.d(MainActivity.TAG, "onComplete")
        }

    }
    observable.subscribe(observer)
}

fun rangeOperator() : Observable<Int> {

    return Observable.range(1,100)

}

fun repeatOperator() : Observable<Int>{
    return Observable.range(1,10).repeat(2)

}

fun intervalOperator():Observable<Long>{
    return Observable.interval(5 , 1,TimeUnit.SECONDS).takeWhile{
        value->value<=10
    }
}

fun filterOperator():Observable<User>{
    return Observable.fromIterable(mUserList)
}
