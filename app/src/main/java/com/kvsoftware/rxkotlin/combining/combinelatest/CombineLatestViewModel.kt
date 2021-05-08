package com.kvsoftware.rxkotlin.combining.combinelatest

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import java.util.concurrent.TimeUnit

class CombineLatestViewModel : ViewModel() {

    fun initialize() {
        combineLatest()
    }

    /**
     * CombineLatest operator - when an item is emitted by either of two Observables, combine
     * the latest item emitted by each Observable via a specified function and emit items based
     * on the results of this function
     */
    private fun combineLatest() {
        val observable1 = Observable.interval(2000, TimeUnit.MILLISECONDS)
        val observable2 = Observable.interval(5000, TimeUnit.MILLISECONDS)
        val biFunction = BiFunction<Long, Long, String> { t1, t2 ->
            return@BiFunction "$t1 : $t2"
        }

        Observable
            .combineLatest(
                observable1,
                observable2,
                biFunction
            )
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("combineLatest() : onSubscribe()")
                }

                override fun onNext(t: String) {
                    LoggerHelper.i("combineLatest() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("combineLatest() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("combineLatest() : onComplete()")
                }
            })
    }

}