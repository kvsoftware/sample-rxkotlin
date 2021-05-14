package com.kvsoftware.rxkotlin.conditionalandboolean.skipuntil

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class SkipUntilViewModel : ViewModel() {

    fun initialize() {
        skipUntil()
    }

    /**
     * SkipUntil operator - discard items emitted by an Observable until a second Observable
     * emits an item
     */
    private fun skipUntil() {
        val observable = Observable.empty<Int>().delay(5000, TimeUnit.MILLISECONDS)

        Observable
            .interval(1000, TimeUnit.MILLISECONDS)
            .skipUntil(observable)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("skipUntil() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("skipUntil() : onError() : $e")
                }

                override fun onNext(t: Long?) {
                    LoggerHelper.i("skipUntil() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("skipUntil() : onComplete")
                }
            })
    }
}


