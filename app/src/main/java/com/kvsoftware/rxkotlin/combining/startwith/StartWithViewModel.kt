package com.kvsoftware.rxkotlin.combining.startwith

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class StartWithViewModel : ViewModel() {

    fun initialize() {
        startWith()
    }

    /**
     * StartWith operator - combine multiple Observables into one by merging their emissions
     */
    private fun startWith() {
        val observable = Observable.just(6, 7)
        Observable
            .just(1, 2, 3, 4, 5)
            .mergeWith(observable)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("startWith() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("startWith() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("startWith() : onComplete()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("startWith() : onNext() : $t")
                }
            })
    }

}