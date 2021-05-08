package com.kvsoftware.rxkotlin.combining.join

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Function
import java.util.concurrent.TimeUnit

class JoinViewModel : ViewModel() {

    fun initialize() {
        join()
    }

    /**
     * Join operator - combine items emitted by two Observables whenever an item from one
     * Observable is emitted during a time window defined according to an item emitted by
     * the other Observable
     */
    private fun join() {

        val observable1 = Observable.interval(1000, TimeUnit.MILLISECONDS)
        val observable2 = Observable.interval(5000, TimeUnit.MILLISECONDS)

        val function1 = Function<Long, Observable<Long>> {
            Observable.just(it)
        }
        val function2 = Function<Long, Observable<Long>> {
            Observable.just(it)
        }

        val biFunction = BiFunction<Long, Long, String> { t1, t2 ->
            return@BiFunction "$t1, $t2"
        }

        observable1.join(observable2, function1, function2, biFunction)
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("join() : onSubscribe()")
                }

                override fun onNext(t: String) {
                    LoggerHelper.i("join() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("join() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("join() : onComplete()")
                }
            })

    }

}