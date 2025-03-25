// Package declaration - Defines which package this file belongs to in your Kotlin project.
package com.awesomeproject

// Importing

// Used to send results back to JavaScript asynchronously.
import com.facebook.react.bridge.Promise

// Provides context for accessing native Android APIs.
import com.facebook.react.bridge.ReactApplicationContext

// Base class for creating a native module.
import com.facebook.react.bridge.ReactContextBaseJavaModule

// Annotation used to expose functions to React Native (JavaScript).
import com.facebook.react.bridge.ReactMethod

// Defining a Kotlin class that extends ReactContextBaseJavaModule.
// This makes it a Native Module that can be accessed from JavaScript.
class FirstNativeModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

    // The `getName()` function specifies the name used to reference this module from JavaScript.
    override fun getName(): String {
        return "FirstNativeModule" // This name will be used in JavaScript to call the module.
    }

    // Function exposed to JavaScript that returns "Print First"
    @ReactMethod
    fun printFirst(promise: Promise) {
        promise.resolve("Print First") // Sends "Print First" as a response to JavaScript.
    }

    // Another function exposed to JavaScript that returns "Print Third"
    @ReactMethod
    fun printThird(promise: Promise) {
        promise.resolve("Print Third") // Sends "Print Third" as a response to JavaScript.
    }
}
