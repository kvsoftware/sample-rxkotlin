package com.kvsoftware.rxkotlin.utility.`do`

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class DoViewModel : ViewModel() {

    /**
     * Do operator - register an action to take upon a variety of Observable lifecycle events
     */
    fun initialize() {
        doOnNext()
        doOnSubscribe()
        doOnComplete()
        doOnError()
        doOnTerminate()
        doFinally()
        doAfterTerminate()
    }

    private fun doOnNext() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doOnNext {
                if (it > 3) {
                    throw Throwable("Test")
                }
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doOnNext() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doOnNext() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doOnNext() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doOnNext() : onComplete()")
                }
            })
    }

    private fun doOnSubscribe() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doOnSubscribe {
                LoggerHelper.i("doOnSubscribe() : doOnSubscribe")
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doOnSubscribe() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doOnSubscribe() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doOnSubscribe() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doOnSubscribe() : onComplete()")
                }
            })
    }

    private fun doOnComplete() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doOnComplete {
                LoggerHelper.i("doOnComplete() : doOnComplete")
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doOnComplete() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doOnComplete() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doOnComplete() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doOnComplete() : onComplete()")
                }
            })
    }

    private fun doOnError() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doOnError {
                LoggerHelper.i("doOnError() : doOnError")
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doOnError() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doOnError() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doOnError() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doOnError() : onComplete()")
                }
            })
    }

    private fun doOnTerminate() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doOnTerminate {
                LoggerHelper.i("doOnTerminate() : doOnTerminate")
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doOnTerminate() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doOnTerminate() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doOnTerminate() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doOnTerminate() : onComplete()")
                }
            })
    }

    private fun doFinally() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doFinally {
                LoggerHelper.i("doFinally() : doFinally")
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doFinally() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doFinally() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doFinally() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doFinally() : onComplete()")
                }
            })
    }

    private fun doAfterTerminate() {
        Observable
            .just(0, 1, 2, 3, 4)
            .doAfterTerminate {
                LoggerHelper.i("doAfterTerminate() : doAfterTerminate")
            }
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("doAfterTerminate() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("doAfterTerminate() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("doAfterTerminate() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("doAfterTerminate() : onComplete()")
                }
            })
    }

}