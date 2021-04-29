package com.kvsoftware.rxkotlin.creating.defer

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class DeferViewModel : ViewModel() {

    fun initialize() {
        defer()
    }

    /**
     * Defer operator - do not create the Observable until the observer subscribes, and create a
     * fresh Observable for each observer
     */
    private fun defer() {
        // Without defer - onNext() : test1
        var test1 = "test1"
        val observable1 = Observable.just(test1)
        test1 = "test1-new"
        observable1.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("defer()-1 : onSubscribe()")
            }

            override fun onNext(t: String?) {
                LoggerHelper.i("defer()-1 : onNext() : $t")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("defer()-1 : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("defer()-1 : onComplete()")
            }
        })

        // With defer - onNext() : test2-new
        var test2 = "test2"
        val observable2 = Observable.defer { Observable.just(test2) }
        test2 = "test2-new"
        observable2.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("defer()-2 : onSubscribe()")
            }

            override fun onNext(t: String?) {
                LoggerHelper.i("defer()-2 : onNext() : $t")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("defer()-2 : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("defer()-2 : onComplete()")
            }
        })
    }

}