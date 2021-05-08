package com.kvsoftware.rxkotlin.filtering.take

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class TakeViewModel : ViewModel() {

    fun initialize() {
        take()
    }

    /**
     * Take operator - emit only the first n items emitted by an Observable
     */
    private fun take() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .take(3)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("take() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("take() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("take() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("take() : onComplete()")
                }
            })
    }

}