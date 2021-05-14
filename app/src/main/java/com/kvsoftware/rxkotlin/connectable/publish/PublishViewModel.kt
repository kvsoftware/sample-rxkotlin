package com.kvsoftware.rxkotlin.connectable.publish

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.observables.ConnectableObservable

class PublishViewModel : ViewModel() {

    fun initialize() {
        publish()
    }

    /**
     * Publish operator - convert an ordinary Observable into a connectable Observable
     */
    private fun publish() {
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