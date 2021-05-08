package com.kvsoftware.rxkotlin.combining.zip

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction

class ZipViewModel : ViewModel() {

    /**
     * Zip operator - combine the emissions of multiple Observables together via a specified
     * function and emit single items for each combination based on the results of this function
     */
    fun initialize() {
        zip()
        zipWith()
    }

    private fun zip() {
        val observable1 = Observable.just(1, 2, 3, 4, 5)
        val observable2 = Observable.just(6, 7, 8, 9, 10)
        val biFunction = BiFunction<Int, Int, Int> { t1, t2 -> t1 + t2 }

        Observable
            .zip(observable1, observable2, biFunction)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("zip() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("zip() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("zip() : onComplete()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("zip() : onNext() : $t")
                }
            })
    }

    private fun zipWith() {
        val observable = Observable.just(6, 7, 8, 9, 10)
        val biFunction = BiFunction<Int, Int, Int> { t1, t2 -> t1 + t2 }

        Observable
            .just(1, 2, 3, 4, 5)
            .zipWith(observable, biFunction)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("zipWith() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("zipWith() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("zipWith() : onComplete()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("zipWith() : onNext() : $t")
                }
            })
    }

}