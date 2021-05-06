package com.kvsoftware.rxkotlin.combining.merge

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MergeViewModel : ViewModel() {

    fun initialize() {
        merge()
    }

    /**
     * Merge operator - combine multiple Observables into one by merging their emissions
     */
    private fun merge() {
        val observable1 = Observable.just(0, 1, 2, 3, 4, 5)
        val observable2 = Observable.just(6, 7, 8, 9, 10, 11)

        Observable.merge(
            observable1,
            observable2
        ).subscribe(object : Observer<Int> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("merge() : onSubscribe()")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("merge() : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("merge() : onComplete()")
            }

            override fun onNext(t: Int) {
                LoggerHelper.i("merge() : onNext() : $t")
            }
        })
    }

}