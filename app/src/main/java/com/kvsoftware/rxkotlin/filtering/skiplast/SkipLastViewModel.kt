package com.kvsoftware.rxkotlin.filtering.skiplast

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class SkipLastViewModel : ViewModel() {

    fun initialize() {
        skipLast()
    }

    /**
     * Skip Last operator - suppress the final n items emitted by an Observable
     */
    private fun skipLast() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .skipLast(2)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("skipLast() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("skipLast() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("skipLast() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("skipLast() : onComplete()")
                }
            })
    }

}