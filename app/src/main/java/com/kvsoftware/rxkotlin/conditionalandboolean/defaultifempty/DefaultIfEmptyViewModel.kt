package com.kvsoftware.rxkotlin.conditionalandboolean.defaultifempty

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class DefaultIfEmptyViewModel : ViewModel() {

    fun initialize() {
        defaultIfEmpty()
    }

    /**
     * DefaultIfEmpty operator - emit items from the source Observable, or a default item if the
     * source Observable emits nothing
     */
    private fun defaultIfEmpty() {
        Observable
            .empty<Int>()
            .defaultIfEmpty(6)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("defaultIfEmpty() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("defaultIfEmpty() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("defaultIfEmpty() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("defaultIfEmpty() : onComplete()")
                }
            })
    }
}


