package com.kvsoftware.rxkotlin.creating.error

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ErrorViewModel : ViewModel() {

    fun initialize() {
        error()
    }

    /**
     * Error operator - create an Observable that emits no items and terminates with an error
     */
    private fun error() {
        Observable
            .error<Throwable> { Throwable() }
            .subscribe(object : Observer<Throwable> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("error() : onSubscribe()")
                }

                override fun onNext(t: Throwable) {
                    LoggerHelper.i("error() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("error() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("error() : onComplete()")
                }
            })
    }

}