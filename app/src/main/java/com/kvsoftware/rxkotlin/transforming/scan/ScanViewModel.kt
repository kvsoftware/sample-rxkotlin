package com.kvsoftware.rxkotlin.transforming.scan

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class ScanViewModel : ViewModel() {

    fun initialize() {
        scan()
    }

    /**
     * Scan operator - apply a function to each item emitted by an Observable, sequentially,
     * and emit each successive value
     */
    private fun scan() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .scan { t1, t2 ->
                LoggerHelper.i("$t1 + $t2")
                t1 + t2
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("scan() : onSubscribe()")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("scan() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("scan() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("scan() : onComplete()")
                }
            })
    }

}