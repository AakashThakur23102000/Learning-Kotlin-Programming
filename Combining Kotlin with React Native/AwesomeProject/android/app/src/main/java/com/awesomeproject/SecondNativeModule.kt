package com.awesomeproject

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class SecondNativeModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "SecondNativeModule"
    }

    @ReactMethod
    fun printSecond(promise: Promise) {
        promise.resolve("Print Second")
    }
}
