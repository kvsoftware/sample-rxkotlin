package com.kvsoftware.rxkotlin.debounce

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

class DebounceViewModel : ViewModel() {

    val data: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }

    fun initialize() {
        search("")
    }

    fun search(text: String) {
        LoggerHelper.i("search : $text")
        Observable
            .fromCallable { getData(text) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = {
                    LoggerHelper.i("onNext() : $it")
                    data.postValue(it)
                },
                onError = {
                    LoggerHelper.i("onError() : $it")
                },
                onComplete = {
                    LoggerHelper.i("onComplete()")
                }
            )
    }

    private fun getData(keyword: String): List<String> {
        return arrayListOf("red", "green", "blue", "yellow").filter { it.contains(keyword) }
    }

}