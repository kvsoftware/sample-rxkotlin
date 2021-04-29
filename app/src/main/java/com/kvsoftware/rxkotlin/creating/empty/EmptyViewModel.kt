package com.kvsoftware.rxkotlin.creating.empty

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class EmptyViewModel : ViewModel() {

    fun initialize() {
        empty()
    }

    /**
     * Empty operator - create an Observable that emits no items but terminates normally
     */
    private fun empty() {
        Observable
            .empty<String>()
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("empty() : onSubscribe()")
                }

                override fun onNext(t: String?) {
                    LoggerHelper.i("empty() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("empty() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("empty() : onComplete()")
                }
            })
    }

}