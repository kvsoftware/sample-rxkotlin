package com.kvsoftware.rxkotlin.conditionalandboolean.sequenceequal

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable

class SequenceEqualViewModel : ViewModel() {

    fun initialize() {
        sequenceEqual()
    }

    /**
     * SequenceEqual operator - determine whether two Observables emit the same sequence of items
     */
    private fun sequenceEqual() {
        val observable1 = Observable.just(0,1,2,3,4,5)
        val observable2 = Observable.just(0,1,2,3,4,6)

        SingleToObservable
            .sequenceEqual(observable1, observable2)
            .subscribe(object : SingleObserver<Boolean> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("sequenceEqual() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("sequenceEqual() : onError() : $e")
                }

                override fun onSuccess(t: Boolean?) {
                    LoggerHelper.i("sequenceEqual() : onSuccess() : $t")
                }
            })
    }
}


