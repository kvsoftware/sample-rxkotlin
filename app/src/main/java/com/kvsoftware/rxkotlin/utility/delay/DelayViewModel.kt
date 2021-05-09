package com.kvsoftware.rxkotlin.utility.delay

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class DelayViewModel : ViewModel() {

    fun initialize() {
        delay()
    }

    /**
     * Delay operator - shift the emissions from an Observable forward in time by a particular
     * amount
     */
    private fun delay() {
        Observable
            .just(0, 1, 2, 3, 4)
            .delay(5000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("delay() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("delay() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("delay() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("delay() : onComplete()")
                }
            })
    }

}