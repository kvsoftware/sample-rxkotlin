package com.kvsoftware.rxkotlin.transforming.window

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class WindowViewModel : ViewModel() {

    fun initialize() {
        window()
    }

    private fun window() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .window(2)
            .subscribe(object : Observer<Observable<Int>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("window() : onSubscribe()")
                }

                override fun onNext(t: Observable<Int>?) {
                    LoggerHelper.i("window() : onNext() : $t")
                    t?.let { subObserve(it) }
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("window() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("window() : onComplete()")
                }
            })
    }

    private fun subObserve(observable: Observable<Int>) {
        observable.subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("subObserve() : onSubscribe()")
            }

            override fun onNext(t: Int) {
                LoggerHelper.i("subObserve() : onNext() : $t")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("subObserve() : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("subObserve() : onComplete()")
            }
        })
    }

}