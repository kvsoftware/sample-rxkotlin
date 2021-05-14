package com.kvsoftware.rxkotlin.connectable.refcount

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.observables.ConnectableObservable

class RefCountViewModel : ViewModel() {

    fun initialize() {
        refCount()
    }

    /**
     * RefCount operator - make a Connectable Observable behave like an ordinary Observable
     */
    private fun refCount() {
        val numbers = arrayListOf(0, 1, 2, 3, 4, 5)
        val result = arrayListOf<Int>()

        val observable1 = ConnectableObservable.fromArray(numbers).publish().refCount()
        LoggerHelper.i("refCount() : ${result.size}")
        // connect when first subscriber subscribes.
        observable1.subscribe { onNext ->
            result.addAll(onNext)
        }
        LoggerHelper.i("refCount() : ${result.size}")
    }

}