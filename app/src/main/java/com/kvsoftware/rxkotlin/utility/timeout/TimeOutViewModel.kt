package com.kvsoftware.rxkotlin.utility.timeout

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Timed
import java.util.concurrent.TimeUnit

class TimeOutViewModel : ViewModel() {

    /**
     * TimeOut operator - mirror the source Observable, but issue an error notification if a
     * particular period of time elapses without any emitted items
     */
    fun initialize() {
        timeOut()
        timeOutWithObservable()
    }

    private fun timeOut() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .delay(3000, TimeUnit.MILLISECONDS)
            .timeout(2000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timeOut() : onSubscribe()")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("timeOut() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    // Get java.util.concurrent.TimeoutException
                    LoggerHelper.i("timeOut() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timeOut() : onComplete()")
                }
            })
    }

    private fun timeOutWithObservable() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .delay(3000, TimeUnit.MILLISECONDS)
            .timeout(2000, TimeUnit.MILLISECONDS, Observable.just(6, 7, 8))
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timeOutWithObservable() : onSubscribe()")
                }

                override fun onNext(t: Int?) {
                    // Get 6, 7, and 8
                    LoggerHelper.i("timeOutWithObservable() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timeOutWithObservable() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timeOutWithObservable() : onComplete()")
                }
            })
    }

}