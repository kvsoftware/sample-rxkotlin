package com.kvsoftware.rxkotlin.filtering.last

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

class LastViewModel : ViewModel() {

    fun initialize() {
        last()
    }

    /**
     * Last operator - emit only the last item (or the last item that meets some condition)
     * emitted by an Observable
     */
    private fun last() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .last(0)
            .subscribe(object : SingleObserver<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("last() : onSubscribe()")
                }

                override fun onSuccess(t: Int?) {
                    LoggerHelper.i("last() : onSuccess() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("last() : onError() : $e")
                }
            })
    }

}