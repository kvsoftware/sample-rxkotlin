package com.kvsoftware.rxkotlin.connectable.replay

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable

class ReplayViewModel : ViewModel() {

    fun initialize() {
        replay()
    }

    /**
     * Replay operator - ensure that all observers see the same sequence of emitted items, even
     * if they subscribe after the Observable has begun emitting items
     */
    private fun replay() {
        val observable1 = Observable.range(1, 5).replay().refCount()
        observable1.subscribe { onNext -> LoggerHelper.i("replay() : OnNext : $onNext") }
        observable1.subscribe { onNext -> LoggerHelper.i("replay() : OnNext : $onNext") }
    }

}