package com.kvsoftware.rxkotlin.basic

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class BasicViewModel : ViewModel() {

    fun initialize() {
        Observable
            .fromCallable { getData() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { LoggerHelper.i("onNext() : $it") },
                onError = { LoggerHelper.i("onError() : $it") },
                onComplete = { LoggerHelper.i("onComplete()") }
            )
    }

    private fun getData(): List<String> {
        return arrayListOf("1", "2", "3", "4", "5")
    }

}