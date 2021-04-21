package com.kvsoftware.rxkotlin.transforming.flatmap

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import com.kvsoftware.rxkotlin.transforming.groupby.PetDataModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class FlatMapViewModel : ViewModel() {

    fun initialize() {
        flatMap()
    }

    /**
     * FlatMap operator - transform the items emitted by an Observable into Observables, then flatten
     * the emissions from those into a single Observable
     */
    private fun flatMap() {
        Observable
            .just("1", "2", "3", "4")
            .flatMap { test ->
                Observable.create<Int> {
                    val number = test.toInt()
                    it.onNext(number)
                    it.onComplete()
                }
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("flatMap() : onSubscribe()")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("flatMap() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("flatMap() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("flatMap() : onComplete()")
                }
            })
    }

}