package com.kvsoftware.rxkotlin.conditionalandboolean.contains

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Predicate
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable

class ContainsViewModel : ViewModel() {

    fun initialize() {
        contains()
    }

    /**
     * Contains operator - determine whether an Observable emits a particular item or not
     */
    private fun contains() {
        SingleToObservable
            .just(0, 1, 2, 3, 4, 5)
            .contains(6)
            .subscribe(object : SingleObserver<Boolean> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("contains() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("contains() : onError() : $e")
                }

                override fun onSuccess(t: Boolean?) {
                    LoggerHelper.i("contains() : onSuccess() : $t")
                }
            })
    }
}


