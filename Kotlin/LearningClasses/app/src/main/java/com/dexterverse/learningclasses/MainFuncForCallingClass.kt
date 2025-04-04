package com.dexterverse.learningclasses

fun main() {
    // parent
    ParentClassWithItsMethod().printIAmParentGenes()

    println()

    //Child
    ChildClassWithItsMethod().printIAmParentGenes()
    ChildClassWithItsMethod().printIAmChildGenes()

    ChildClassWithItsMethod().height()
    ChildClassWithItsMethod().sing()
}