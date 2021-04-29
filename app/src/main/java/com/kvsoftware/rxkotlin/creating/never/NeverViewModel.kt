package com.kvsoftware.rxkotlin.creating.never

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class NeverViewModel : ViewModel() {

    fun initialize() {
        never()
    }

    /**
     * Never operator - create an Observable that emits no items but terminates normally
     */
    private fun never() {
        Observable
            .never<String>()
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("never() : onSubscribe()")
                }

                override fun onNext(t: String?) {
                    LoggerHelper.i("never() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("never() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("never() : onComplete()")
                }
            })
    }

}