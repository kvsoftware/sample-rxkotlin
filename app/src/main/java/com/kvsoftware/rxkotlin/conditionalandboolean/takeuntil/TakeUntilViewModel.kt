package com.kvsoftware.rxkotlin.conditionalandboolean.takeuntil

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable
import java.util.concurrent.TimeUnit

class TakeUntilViewModel : ViewModel() {

    fun initialize() {
        takeUntil()
    }

    /**
     * TakeUntil operator - discard any items emitted by an Observable after a second Observable
     * emits an item or terminates
     */
    private fun takeUntil() {
        val observable = Observable.empty<Int>().delay(5000, TimeUnit.MILLISECONDS)

        Observable
            .interval(1000, TimeUnit.MILLISECONDS)
            .takeUntil(observable)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("takeUntil() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("takeUntil() : onError() : $e")
                }

                override fun onNext(t: Long?) {
                    LoggerHelper.i("takeUntil() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("takeUntil() : onComplete")
                }
            })
    }
}


