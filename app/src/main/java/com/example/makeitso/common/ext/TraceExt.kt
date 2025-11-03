package com.example.makeitso.common.ext

import com.google.firebase.perf.FirebasePerformance
import com.google.firebase.perf.metrics.Trace

suspend inline fun <T> trace(name: String, crossinline block: suspend Trace.() -> T): T {
    val trace = FirebasePerformance.getInstance().newTrace(name)
    trace.start()
    val result = trace.block()
    trace.stop()
    return result
}
