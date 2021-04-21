package com.kvsoftware.rxkotlin.transforming

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class TransformingViewModel : ViewModel() {

    fun initialize() {
        buffer()
        flatMap()
    }

    /**
     * Buffer - periodically gather items from an Observable into bundles and emit these bundles
     * rather than emitting the items one at a time
     */
    private fun buffer() {
        Observable
            .create<String> {
                it.onNext("1")
                it.onNext("2")
                it.onNext("3")
                it.onNext("4")
                it.onNext("5")
                it.onNext("6")
                it.onNext("7")
                it.onComplete()
            }
            .buffer(2)
            .subscribe(object : Observer<List<String>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("buffer() : onSubscribe()")
                }

                override fun onNext(t: List<String>?) {
                    LoggerHelper.i("buffer() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("buffer() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("buffer() : onComplete()")
                }
            })
    }

    /**
     * FlatMap - transform the items emitted by an Observable into Observables, then flatten
     * the emissions from those into a single Observable
     */
    private fun flatMap() {
        Observable
            .create<String> {
                it.onNext("1")
                it.onNext("2")
                it.onComplete()
            }
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