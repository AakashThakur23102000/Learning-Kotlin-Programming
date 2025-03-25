package com.awesomeproject


import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext

class MyNativeModulePackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
        return listOf(
            FirstNativeModule(reactContext),
            SecondNativeModule(reactContext)
        )
    }

    override fun createViewManagers(reactContext: ReactApplicationContext) = emptyList<Nothing>()
}
