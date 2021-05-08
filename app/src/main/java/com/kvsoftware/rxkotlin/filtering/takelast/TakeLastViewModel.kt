package com.kvsoftware.rxkotlin.filtering.takelast

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class TakeLastViewModel : ViewModel() {

    fun initialize() {
        takeLast()
    }

    /**
     * Take Last operator - emit only the last n items emitted by an Observable
     */
    private fun takeLast() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .takeLast(2)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("takeLast() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("takeLast() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("takeLast() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("takeLast() : onComplete()")
                }
            })
    }

}