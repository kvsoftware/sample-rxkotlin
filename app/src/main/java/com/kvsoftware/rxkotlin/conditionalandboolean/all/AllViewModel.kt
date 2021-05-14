package com.kvsoftware.rxkotlin.conditionalandboolean.all

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Predicate
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable

class AllViewModel : ViewModel() {

    fun initialize() {
        all()
    }

    /**
     * All operator - determine whether all items emitted by an Observable meet some criteria
     */
    private fun all() {
        SingleToObservable
            .just(0, 1, 2, 3, 4, 5)
            .all(Predicate { it < 3 })
            .subscribe(object : SingleObserver<Boolean> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("all() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("all() : onError() : $e")
                }

                override fun onSuccess(t: Boolean?) {
                    LoggerHelper.i("all() : onSuccess() : $t")
                }
            })
    }
}


