package com.kvsoftware.rxkotlin.utility.timestamp

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Timed
import java.util.concurrent.TimeUnit

class TimestampViewModel : ViewModel() {

    /**
     * Timestamp operator - mirror the source Observable, but issue an error notification if a
     * particular period of time elapses without any emitted items
     */
    fun initialize() {
        timestamp()
    }

    private fun timestamp() {
        Observable
            .intervalRange(1, 10, 1000, 1000, TimeUnit.MILLISECONDS)
            .timestamp()
            .subscribe(object : Observer<Timed<Long>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timestamp() : onSubscribe()")
                }

                override fun onNext(t: Timed<Long>?) {
                    LoggerHelper.i("timestamp() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timestamp() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timestamp() : onComplete()")
                }
            })
    }

}