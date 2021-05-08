package com.kvsoftware.rxkotlin.filtering.sample

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class SampleViewModel : ViewModel() {

    fun initialize() {
        sample()
    }

    /**
     * Sample operator - emit the most recent items emitted by an Observable within periodic time
     * intervals
     */
    private fun sample() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .sample(1000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("sample() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("sample() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("sample() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("sample() : onComplete()")
                }
            })
    }

}