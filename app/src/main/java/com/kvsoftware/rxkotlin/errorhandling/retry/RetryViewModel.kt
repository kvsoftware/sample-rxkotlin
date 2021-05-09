package com.kvsoftware.rxkotlin.errorhandling.retry

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import java.util.concurrent.TimeUnit

class RetryViewModel : ViewModel() {

    /**
     * Retry operator - if a source Observable emits an error, resubscribe to it in the hopes
     * that it will complete without error
     */
    fun initialize() {
        retry()
        retryWhen()
    }

    private fun retry() {
        Observable
            .create<Int> {
                it.onNext(1)
                it.onNext(2)
                it.onError(Throwable("Test"))
                it.onComplete()
            }
            .retry(3)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("retry() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("retry() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("retry() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("retry() : onComplete()")
                }
            })
    }

    private fun retryWhen() {
        val rangeObservable = Observable.range(1, 3)
        val biFunction = BiFunction<Throwable, Int, Long> { t1, t2 ->
            return@BiFunction t2.toLong()
        }

        Observable
            .create<Int> {
                it.onNext(1)
                it.onNext(2)
                it.onError(Throwable("Test"))
                it.onComplete()
            }
            .retryWhen { error ->
                error.zipWith(rangeObservable, biFunction).flatMap { i ->
                    Observable.timer(i, TimeUnit.SECONDS)
                }
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("retryWhen() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("retryWhen() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("retryWhen() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("retryWhen() : onComplete()")
                }
            })
    }

}