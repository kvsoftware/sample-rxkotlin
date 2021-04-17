package com.kvsoftware.rxkotlin

import android.util.Log

object LoggerHelper {
    private const val TAG = "Kv"

    fun i(msg: String) {
        Log.i(TAG, msg)
    }
}