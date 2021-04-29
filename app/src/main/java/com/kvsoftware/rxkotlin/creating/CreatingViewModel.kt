package com.kvsoftware.rxkotlin.creating

import androidx.lifecycle.ViewModel
import com.kvsoftware.rxkotlin.LoggerHelper
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.concurrent.TimeUnit

class CreatingViewModel : ViewModel() {

    fun initialize() {
//        create()
//        defer()
//        empty()
//        never()
//        error()
//        interval()
//        just()
//        range()
//        repeat()
//        timer()
    }

    /**
     * Create operator - create an observable from scratch
     */
    private fun create() {
        Observable
            .create<String> {
                it.onNext("1")
                it.onNext("2")
                it.onNext("3")
                it.onComplete()
            }
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("create() : onSubscribe()")
                }

                override fun onNext(t: String?) {
                    LoggerHelper.i("create() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("create() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("create() : onComplete()")
                }
            })
    }

    /**
     * Defer operator - do not create the observable until the observer subscribes, and create a
     * fresh observable for each observer
     */
    private fun defer() {
        // Without defer - onNext() : test1
        var test1 = "test1"
        val observable1 = Observable.just(test1)
        test1 = "test1-new"
        observable1.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("defer()-1 : onSubscribe()")
            }

            override fun onNext(t: String?) {
                LoggerHelper.i("defer()-1 : onNext() : $t")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("defer()-1 : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("defer()-1 : onComplete()")
            }
        })

        // With defer - onNext() : test2-new
        var test2 = "test2"
        val observable2 = Observable.defer { Observable.just(test2) }
        test2 = "test2-new"
        observable2.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                LoggerHelper.i("defer()-2 : onSubscribe()")
            }

            override fun onNext(t: String?) {
                LoggerHelper.i("defer()-2 : onNext() : $t")
            }

            override fun onError(e: Throwable?) {
                LoggerHelper.i("defer()-2 : onError() : $e")
            }

            override fun onComplete() {
                LoggerHelper.i("defer()-2 : onComplete()")
            }
        })
    }

    /**
     * Empty operator - create an observable that emits no items but terminates normally
     */
    private fun empty() {
        Observable
            .empty<String>()
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("empty() : onSubscribe()")
                }

                override fun onNext(t: String?) {
                    LoggerHelper.i("empty() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("empty() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("empty() : onComplete()")
                }
            })
    }

    /**
     * Never operator - create an Observable that emits no items and does not terminate
     */
    private fun never() {
        Observable
            .never<String>()
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("never() : onSubscribe()")
                }

                override fun onNext(t: String?) {
                    LoggerHelper.i("never() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("never() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("never() : onComplete()")
                }
            })
    }

    /**
     * Error operator - create an Observable that emits no items and terminates with an error
     */
    private fun error() {
        Observable
            .error<Throwable> { Throwable() }
            .subscribe(object : Observer<Throwable> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("error() : onSubscribe()")
                }

                override fun onNext(t: Throwable) {
                    LoggerHelper.i("error() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("error() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("error() : onComplete()")
                }
            })
    }

    /**
     * Interval operator - create an observable that emits a sequence of integers spaced by a given
     * time interval
     */
    private fun interval() {
        Observable
            .interval(1000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("interval() : onSubscribe()")
                }

                override fun onNext(t: Long) {
                    LoggerHelper.i("interval() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("interval() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("interval() : onComplete()")
                }
            })
    }

    /**
     * Just operator - create an Observable that emits a particular item
     */
    private fun just() {
        Observable
            .just("Item")
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("just() : onSubscribe()")
                }

                override fun onNext(t: String) {
                    LoggerHelper.i("just() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("just() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("just() : onComplete()")
                }
            })
    }

    /**
     * Range operator - create an observable that emits a particular range of sequential integers
     */
    private fun range() {
        Observable
            .range(0, 10)
            .subscribe(object : Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("range() : onSubscribe()")
                }

                override fun onNext(t: Int) {
                    LoggerHelper.i("range() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("range() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("range() : onComplete()")
                }
            })
    }

    /**
     * Repeat operator - create an observable that emits a particular item multiple times
     */
    private fun repeat() {
        Observable
            .just("a", "b")
            .repeat(5)
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("repeat() : onSubscribe()")
                }

                override fun onNext(t: String) {
                    LoggerHelper.i("repeat() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("repeat() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("repeat() : onComplete()")
                }
            })
    }

    /**
     * Timer operator - create an observable that emits a particular item after a given delay
     */
    private fun timer() {
        Observable
            .timer(2000, TimeUnit.MILLISECONDS)
            .subscribe(object : Observer<Long> {
                override fun onSubscribe(d: Disposable?) {
                    LoggerHelper.i("timer() : onSubscribe()")
                }

                override fun onNext(t: Long) {
                    LoggerHelper.i("timer() : onNext() : $t")
                }

                override fun onError(e: Throwable?) {
                    LoggerHelper.i("timer() : onError() : $e")
                }

                override fun onComplete() {
                    LoggerHelper.i("timer() : onComplete()")
                }
            })
    }

}