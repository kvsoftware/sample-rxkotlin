package com.kvsoftware.rxkotlin.transforming.map

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MapViewModel : ViewModel() {

    fun initialize() {
        map()
    }

    /**
     * Map operator - transform the items emitted by an Observable by applying a function to
     * each item
     */
    private fun map() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .map { it * 5 }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("map() : onSubscribe()")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("map() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("map() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("map() : onComplete()")
                }
            })
    }

}