package com.dexterverse.learningclasses;

public open class ParentClassWithItsMethod() {
    fun printIAmParentGenes() {
        println("I am parent genes.");
    }

    // this is a overriding function which can be of parent or child can override it.
    open fun height() {
        println("Parent passed 6 feet height.")
    }
}
