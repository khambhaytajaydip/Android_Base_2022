package com.jai.base.utils

import kotlinx.coroutines.*

/**
 * Created by Jaydeep Khambhayta
 */
object AppCoroutines {
    fun main(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.Main).launch {
        try {
            work()
        } catch (E: Exception) {
            E.printStackTrace()
        }
    }

    fun io(work: suspend (() -> Unit)) = CoroutineScope(Dispatchers.IO).launch {
        try {
            work()
        } catch (E: Exception) {
            E.printStackTrace()
        }
    }

    fun blocking(work: suspend () -> Unit) = runBlocking {
        work()
    }

}