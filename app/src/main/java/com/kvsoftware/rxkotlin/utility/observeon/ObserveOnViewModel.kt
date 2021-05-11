package com.kvsoftware.rxkotlin.utility.observeon

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ObserveOnViewModel : ViewModel() {

    fun initialize() {
        observeOn()
    }

    /**
     * ObserveOn operator - specify the Scheduler on which an observer will observe this Observable
     */
    private fun observeOn() {
        Observable
                .just("")
                .map {
                    // main
                    LoggerHelper.i("observeOn() : map#1 : " + Thread.currentThread().name)
                    it
                }
                .observeOn(Schedulers.io())
                .map {
                    // RxCachedThreadScheduler-1
                    LoggerHelper.i("observeOn() : map#2 : " + Thread.currentThread().name)
                    it
                }
                .observeOn(Schedulers.computation())
                .map {
                    // RxComputationThreadPool-1
                    LoggerHelper.i("observeOn() : map#3 : " + Thread.currentThread().name)
                    it
                }
                .observeOn(Schedulers.computation())
                .subscribe(object : Observer<String> {
                    override fun onSubscribe(d: Disposable?) {
                        // main
                        LoggerHelper.i("observeOn() : onSubscribe() : " + Thread.currentThread().name)
                    }

                    override fun onNext(t: String?) {
                        LoggerHelper.i("observeOn() : onNext() : $t")
                    }

                    override fun onError(e: Throwable?) {
                        LoggerHelper.i("observeOn() : onError() : $e")
                    }

                    override fun onComplete() {
                        LoggerHelper.i("observeOn() : onComplete()")
                    }
                })
    }

}