package com.kvsoftware.rxkotlin.utility.materialize

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Notification
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MaterializeViewModel : ViewModel() {

    private var materializeObservable: Observable<Notification<Int>>? = null

    /**
     * Materialize/Dematerialize operator - represent both the items emitted and the notifications
     * sent as emitted items, or reverse this process
     */
    fun initialize() {
        materialize()
        deMaterialize()
    }

    private fun materialize() {
        materializeObservable = Observable
            .just(0, 1, 2, 3, 4, 5)
            .materialize()
        materializeObservable?.subscribe(object : Observer<Notification<Int>> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("materialize() : onSubscribe()")
            }

            override fun onNext(t: Notification<Int>?) {
                LoggerHelper.i("materialize() : onNext() : $t")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("materialize() : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("materialize() : onComplete()")
            }
        })
    }

    private fun deMaterialize() {
        materializeObservable
            ?.dematerialize { it -> it }
            ?.subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("dematerialize() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("dematerialize() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("dematerialize() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("dematerialize() : onComplete()")
                }
            })
    }

}