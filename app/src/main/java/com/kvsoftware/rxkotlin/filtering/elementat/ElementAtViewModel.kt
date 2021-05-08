package com.kvsoftware.rxkotlin.filtering.elementat

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable

class ElementAtViewModel : ViewModel() {

    fun initialize() {
        elementAt()
    }

    /**
     * ElementAt operator - emit only item n emitted by an Observable
     */
    private fun elementAt() {
        Observable
            .just(0, 0, 1, 1, 2, 2)
            .elementAt(2)
            .subscribe(object : MaybeObserver<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("elementAt() : onSubscribe()")
                }

                override fun onSuccess(t: Int?) {
                    LoggerHelper.i("elementAt() : onSuccess() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("elementAt() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("elementAt() : onComplete()")
                }
            })
    }

}