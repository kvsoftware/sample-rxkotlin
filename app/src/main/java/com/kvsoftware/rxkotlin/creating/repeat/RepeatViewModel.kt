package com.kvsoftware.rxkotlin.creating.repeat

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class RepeatViewModel : ViewModel() {

    fun initialize() {
        repeat()
    }

    /**
     * Repeat operator - create an Observable that emits a range of sequential integers
     */
    private fun repeat() {
        Observable
            .just("a", "b")
            .repeat(5)
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("repeat() : onSubscribe()")
                }

                override fun onNext(t: String) {
                    LoggerHelper.i("repeat() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("repeat() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("repeat() : onComplete()")
                }
            })
    }

}