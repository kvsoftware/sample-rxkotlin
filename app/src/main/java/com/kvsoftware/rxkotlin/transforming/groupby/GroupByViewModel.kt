package com.kvsoftware.rxkotlin.transforming.groupby

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class GroupByViewModel : ViewModel() {

    fun initialize() {
        groupBy()
    }

    /**
     * GroupBy operator - divide an Observable into a set of Observables that each emit a different subset
     * of items from the original Observable
     */
    private fun groupBy() {
        Observable
            .just(
                PetDataModel(name = "Bella", type = PetDataModel.TYPE_CAT),
                PetDataModel(name = "Charlie", type = PetDataModel.TYPE_DOG),
                PetDataModel(name = "Luna", type = PetDataModel.TYPE_DOG),
                PetDataModel(name = "Lucy", type = PetDataModel.TYPE_CAT)
            )
            .groupBy { it.type }
            .flatMapSingle { it.toList() }
            .subscribe(object : Observer<List<PetDataModel>> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("groupBy() : onSubscribe()")
                }

                override fun onNext(t: List<PetDataModel>?) {
                    LoggerHelper.i("groupBy() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("groupBy() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("groupBy() : onComplete()")
                }
            })
    }

}