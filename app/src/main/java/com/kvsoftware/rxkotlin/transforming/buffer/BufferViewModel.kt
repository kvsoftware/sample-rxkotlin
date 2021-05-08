package com.kvsoftware.rxkotlin.transforming.buffer

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import com.kvsoftware.rxkotlin.transforming.groupby.PetDataModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class BufferViewModel : ViewModel() {

    fun initialize() {
        buffer()
    }

    /**
     * Buffer operator - periodically gather items from an Observable into bundles and emit these bundles
     * rather than emitting the items one at a time
     */
    private fun buffer() {
        Observable.just(1,2,3,4,5,6,7,8,9,10)
            .buffer(2)
            .subscribe(object : Observer<List<Int>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("buffer() : onSubscribe()")
                }

                override fun onNext(t: List<Int>?) {
                    LoggerHelper.i("buffer() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("buffer() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("buffer() : onComplete()")
                }
            })
    }

}