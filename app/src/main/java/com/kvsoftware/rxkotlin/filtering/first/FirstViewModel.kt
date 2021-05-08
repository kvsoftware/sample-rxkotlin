package com.kvsoftware.rxkotlin.filtering.first

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

class FirstViewModel : ViewModel() {

    fun initialize() {
        first()
    }

    /**
     * First operator - emit only the first item (or the first item that meets some condition)
     * emitted by an Observable
     */
    private fun first() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .first(0)
            .subscribe(object : SingleObserver<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("first() : onSubscribe()")
                }

                override fun onSuccess(t: Int?) {
                    LoggerHelper.i("first() : onSuccess() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("first() : onError() : $e")
                }
            })
    }

}