package com.kvsoftware.rxkotlin.creating.from

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Action

class FromViewModel : ViewModel() {

    /**
     * From operator - create an Observable that emits no items but terminates normally
     */
    fun initialize() {
        fromArray()
        fromCallable()
        fromIterable()
        fromAction()
        fromRunnable()
    }

    private fun fromArray() {
        val items = arrayOf(0, 1, 2, 3, 4, 5)
        Observable
            .fromArray(items)
            .subscribe(object : Observer<Array<Int>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("fromArray() : onSubscribe()")
                }

                override fun onNext(t: Array<Int>) {
                    LoggerHelper.i("fromArray() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("fromArray() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("fromArray() : onComplete()")
                }
            })
    }

    private fun fromCallable() {
        Observable
            .fromCallable { "Callable" }
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("fromCallable() : onSubscribe()")
                }

                override fun onNext(t: String) {
                    LoggerHelper.i("fromCallable() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("fromCallable() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("fromCallable() : onComplete()")
                }
            })
    }

    private fun fromIterable() {
        val test = arrayListOf(0, 1, 2, 3, 4, 5)
        Observable
            .fromIterable(test)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("fromIterable() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("fromIterable() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("fromIterable() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("fromIterable() : onComplete()")
                }
            })
    }

    private fun fromAction() {
        val action = Action { LoggerHelper.i("fromAction() : Action") }
        Observable
            .fromAction<Int>(action)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("fromAction() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("fromAction() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("fromAction() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("fromAction() : onComplete()")
                }
            })
    }

    private fun fromRunnable() {
        val runnable = Runnable { LoggerHelper.i("fromRunnable() : create Runnable") }
        Observable
            .fromRunnable<Int>(runnable)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("fromRunnable() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("fromRunnable() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("fromRunnable() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("fromRunnable() : onComplete()")
                }
            })
    }

}