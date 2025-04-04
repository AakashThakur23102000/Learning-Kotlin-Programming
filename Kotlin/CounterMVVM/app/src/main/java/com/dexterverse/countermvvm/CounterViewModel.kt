package com.dexterverse.countermvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    //private variable is not exposed outside
    private val _count = mutableIntStateOf(0)

    //for outside accessing the value
    val count: MutableState<Int> = _count

    fun incrementCount() {
        _count.intValue++
    }

    fun decrementCount() {
        _count.intValue--
    }
}