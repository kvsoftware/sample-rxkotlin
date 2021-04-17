package com.kvsoftware.rxkotlin.map

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class MapViewModel : ViewModel() {

    fun initialize() {
        Observable
            .fromCallable { getData() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            // Transform the item emitted
            .map {
                it * 5
            }
            .subscribeBy(
                onNext = { LoggerHelper.i("onNext() : $it") },
                onError = { LoggerHelper.i("onError() : $it") },
                onComplete = { LoggerHelper.i("onComplete()") }
            )
    }

    private fun getData(): Int {
        return 5
    }

}