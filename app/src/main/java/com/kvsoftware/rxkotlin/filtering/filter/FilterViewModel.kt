package com.kvsoftware.rxkotlin.filtering.filter

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class FilterViewModel : ViewModel() {

    fun initialize() {
        filter()
    }

    /**
     * Filter operator - emit only those items from an Observable that pass a predicate test
     */
    private fun filter() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .filter { it > 2 }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("filter() : onSubscribe()")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("filter() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("filter() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("filter() : onComplete()")
                }
            })
    }

}