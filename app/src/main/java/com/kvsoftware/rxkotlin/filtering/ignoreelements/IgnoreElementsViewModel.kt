package com.kvsoftware.rxkotlin.filtering.ignoreelements

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

class IgnoreElementsViewModel : ViewModel() {

    fun initialize() {
        ignoreElements()
    }

    /**
     * Ignore Elements operator - do not emit any items from an Observable but mirror its
     * termination notification
     */
    private fun ignoreElements() {
        Observable
            .just(0, 1, 2, 3, 4, 5)
            .ignoreElements()
            .subscribe(object : CompletableObserver {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("ignoreElements() : onSubscribe()")
                }

                override fun onComplete() {
                    LoggerHelper.i("ignoreElements() : onComplete()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("ignoreElements() : onError() : $e")
                }
            })
    }

}