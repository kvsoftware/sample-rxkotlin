package com.kvsoftware.rxkotlin.creating.range

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class RangeViewModel : ViewModel() {

    fun initialize() {
        range()
    }

    /**
     * Range operator - create an Observable that emits a particular range of sequential integers
     */
    private fun range() {
        Observable
            .range(0, 10)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("range() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("range() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("range() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("range() : onComplete()")
                }
            })
    }

}