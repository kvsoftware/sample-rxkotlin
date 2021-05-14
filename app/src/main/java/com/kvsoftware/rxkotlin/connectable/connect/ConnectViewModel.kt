package com.kvsoftware.rxkotlin.connectable.connect

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.observables.ConnectableObservable

class ConnectViewModel : ViewModel() {

    fun initialize() {
        connect()
    }

    /**
     * Connect operator - instruct a connectable Observable to begin emitting items to its
     * subscribers
     */
    private fun connect() {
        val numbers = arrayListOf(0, 1, 2, 3, 4, 5)
        val result = arrayListOf<Int>()

        val observable1 = ConnectableObservable.fromArray(numbers).publish()
        observable1.subscribe { onNext ->
            result.addAll(onNext)
        }
        LoggerHelper.i("connect() : ${result.size}")

        observable1.connect()
        LoggerHelper.i("connect() : ${result.size}")

    }

}