package com.kvsoftware.rxkotlin.conditionalandboolean.amb

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class AmbViewModel : ViewModel() {

    fun initialize() {
        amb()
    }

    /**
     * Amb operator - given two or more source Observables, emit all of the items from only the
     * first of these Observables to emit an item or notification
     */
    private fun amb() {
        val observable1 = Observable.create<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onNext(4)
            it.onComplete()
        }.delay(2000, TimeUnit.MILLISECONDS)

        val observable2 = Observable.create<Int> {
            it.onNext(5)
            it.onNext(6)
            it.onNext(7)
            it.onNext(8)
            it.onComplete()
        }.delay(4000, TimeUnit.MILLISECONDS)

        val observables = arrayListOf(observable1, observable2)

        Observable
            .amb(observables)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("amb() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("amb() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("amb() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("amb() : onComplete()")
                }
            })
    }
}


