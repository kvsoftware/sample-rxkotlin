package com.kvsoftware.rxkotlin.filtering.distinct

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import com.kvsoftware.rxkotlin.transforming.groupby.PetDataModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class DistinctViewModel : ViewModel() {

    fun initialize() {
        distinct()
    }

    /**
     * Distinct operator - suppress duplicate items emitted by an Observable
     */
    private fun distinct() {
        Observable
            .just(0, 0, 1, 1, 2, 2)
            .distinct()
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("distinct() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("distinct() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("distinct() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("distinct() : onComplete()")
                }
            })
    }

}