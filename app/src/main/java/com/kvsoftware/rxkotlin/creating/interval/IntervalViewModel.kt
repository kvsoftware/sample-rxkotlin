package com.kvsoftware.rxkotlin.creating.interval

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class IntervalViewModel : ViewModel() {

    fun initialize() {
        interval()
    }

    /**
     * Interval operator - create an Observable that emits a sequence of integers spaced by a
     * given time interval
     */
    private fun interval() {
        Observable
            .interval(1000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("interval() : onSubscribe()")
                }

                override fun onNext(t: Long) {
                    LoggerHelper.i("interval() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("interval() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("interval() : onComplete()")
                }
            })
    }

}