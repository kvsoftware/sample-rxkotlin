package com.kvsoftware.rxkotlin.filtering.debounce

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.addTextChangedListener
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CustomEditText : AppCompatEditText {

    companion object {
        const val TIME_OUT = 1000L
    }

    interface Listener {
        fun onTextChanged(text: String)
    }

    var listener: Listener? = null

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        Observable
            .create<String> {
                addTextChangedListener { editText ->
                    val input = editText.toString()
                    LoggerHelper.i("Input : $input")
                    it.onNext(input)
                }
            }
            .debounce(TIME_OUT, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .subscribeBy(onNext = { listener?.onTextChanged(it) })
    }

}