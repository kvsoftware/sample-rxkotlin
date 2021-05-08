package com.kvsoftware.rxkotlin.errorhandling.catch

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class CatchViewModel : ViewModel() {

    fun initialize() {
        catch()
    }

    /**
     * Catch operator - recover from an onError notification by continuing the sequence without
     * error
     */
    private fun catch() {
        Observable
            .create<Int> {
                it.onError(java.lang.Exception("Test"))
                it.onComplete()
            }
            .onErrorResumeNext { it -> return@onErrorResumeNext Observable.just(1) }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("catch() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("catch() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("catch() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("catch() : onComplete()")
                }
            })
    }

}