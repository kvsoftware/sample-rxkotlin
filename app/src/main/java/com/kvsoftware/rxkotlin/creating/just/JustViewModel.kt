package com.kvsoftware.rxkotlin.creating.just

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class JustViewModel : ViewModel() {

    fun initialize() {
        just()
    }

    /**
     * Just operator - create an Observable that emits a particular item
     */
    private fun just() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("just() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("just() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("just() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("just() : onComplete()")
                }
            })
    }

}