package com.kvsoftware.rxkotlin.creating.create

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class CreateViewModel : ViewModel() {

    fun initialize() {
        create()
    }

    /**
     * Create operator - create an Observable from scratch by calling observer methods
     * programmatically
     */
    private fun create() {
        Observable
            .create<Int> {
                it.onNext(0)
                it.onNext(1)
                it.onNext(2)
                it.onComplete()
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("create() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("create() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("create() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("create() : onComplete()")
                }
            })
    }

}