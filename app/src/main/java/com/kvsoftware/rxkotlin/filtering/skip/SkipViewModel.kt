package com.kvsoftware.rxkotlin.filtering.skip

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class SkipViewModel : ViewModel() {

    fun initialize() {
        skip()
    }

    /**
     * Skip operator - suppress the first n items emitted by an Observable
     */
    private fun skip() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .skip(3)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("skip() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("skip() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("skip() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("skip() : onComplete()")
                }
            })
    }

}