package com.kvsoftware.rxkotlin.conditionalandboolean.skipwhile

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Predicate

class SkipWhileViewModel : ViewModel() {

    fun initialize() {
        skipWhile()
    }

    /**
     * SkipWhile operator - discard items emitted by an Observable until a specified condition
     * becomes false
     */
    private fun skipWhile() {
        val predicate = Predicate<Int> { return@Predicate it < 5 }

        Observable
            .range(0, 10)
            .skipWhile(predicate)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("skipWhile() : onSubscribe()")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("skipWhile() : onError() : $e")
                }

                override fun onNext(t: Int?) {
                    LoggerHelper.i("skipWhile() : onNext() : $t")
                }

                override fun onComplete() {
                    LoggerHelper.i("skipWhile() : onComplete")
                }
            })
    }
}


