package com.kvsoftware.rxkotlin.creating.timer

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class TimerViewModel : ViewModel() {

    fun initialize() {
        timer()
    }

    /**
     * Timer operator - create an Observable that emits a particular item after a given delay
     */
    private fun timer() {
        Observable
            .timer(2000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timer() : onSubscribe()")
                }

                override fun onNext(t: Long) {
                    LoggerHelper.i("timer() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timer() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timer() : onComplete()")
                }
            })
    }

}