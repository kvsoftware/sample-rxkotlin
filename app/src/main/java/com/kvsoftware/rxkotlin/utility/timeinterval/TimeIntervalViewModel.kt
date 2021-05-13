package com.kvsoftware.rxkotlin.utility.timeinterval

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Timed
import java.util.concurrent.TimeUnit

class TimeIntervalViewModel : ViewModel() {

    /**
     * TimeInterval operator - convert an Observable that emits items into one that emits
     * indications of the amount of time elapsed between those emissions
     */
    fun initialize() {
        timeInterval()
        timeIntervalWithTimeUnit()
        timeIntervalWithSchedulers()
    }

    private fun timeInterval() {
        Observable
            .intervalRange(1, 10, 1000, 1000, TimeUnit.MILLISECONDS)
            .timeInterval()
            .subscribe(object : Observer<Timed<Long>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timeInterval() : onSubscribe()")
                }

                override fun onNext(t: Timed<Long>?) {
                    LoggerHelper.i("timeInterval() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timeInterval() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timeInterval() : onComplete()")
                }
            })
    }

    private fun timeIntervalWithTimeUnit() {
        Observable
            .intervalRange(1, 10, 1000, 3000, TimeUnit.MILLISECONDS)
            .timeInterval(TimeUnit.SECONDS)
            .subscribe(object : Observer<Timed<Long>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timeIntervalWithTimeUnit() : onSubscribe()")
                }

                override fun onNext(t: Timed<Long>?) {
                    LoggerHelper.i("timeIntervalWithTimeUnit() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timeIntervalWithTimeUnit() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timeIntervalWithTimeUnit() : onComplete()")
                }
            })
    }

    private fun timeIntervalWithSchedulers() {
        Observable
            .intervalRange(1, 10, 1000, 1000, TimeUnit.MILLISECONDS)
            .timeInterval(Schedulers.io())
            .subscribe(object : Observer<Timed<Long>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timeIntervalWithSchedulers() : onSubscribe()")
                }

                override fun onNext(t: Timed<Long>?) {
                    // RxComputationThreadPool-1
                    LoggerHelper.i("timeIntervalWithSchedulers() : onNext() : ${Thread.currentThread().name} : ${t.toString()}")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timeIntervalWithSchedulers() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timeIntervalWithSchedulers() : onComplete()")
                }
            })
    }

}