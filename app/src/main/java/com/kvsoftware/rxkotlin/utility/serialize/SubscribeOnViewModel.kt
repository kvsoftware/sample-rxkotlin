package com.kvsoftware.rxkotlin.utility.serialize

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers

class SubscribeOnViewModel : ViewModel() {

    fun initialize() {
        subscribeOn()
    }

    /**
     * SubscribeOn operator - specify the Scheduler on which an Observable will operate
     */
    private fun subscribeOn() {
        Observable
            .just(0,1,2,3,4,5)
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    // main
                    LoggerHelper.i("subscribeOn() : onSubscribe() : " + Thread.currentThread().name)
                }

                override fun onNext(t: Int?) {
                    // RxCachedThreadScheduler-1
                    LoggerHelper.i("subscribeOn() : onNext() : " + Thread.currentThread().name + " : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("subscribeOn() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("subscribeOn() : onComplete()")
                }
            })
    }

}