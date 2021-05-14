package com.kvsoftware.rxkotlin.conditionalandboolean.takewhile

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Predicate

class TakeWhileViewModel : ViewModel() {

    fun initialize() {
        takeWhile()
    }

    /**
     * TakeWhile operator - discard items emitted by an Observable after a specified condition
     * becomes false
     */
    private fun takeWhile() {
        val predicate = Predicate<Int> { return@Predicate it < 5 }

        Observable
            .range(0, 10)
            .takeWhile(predicate)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("takeWhile() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("takeWhile() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("takeWhile() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("takeWhile() : onComplete")
                }
            })
    }
}


