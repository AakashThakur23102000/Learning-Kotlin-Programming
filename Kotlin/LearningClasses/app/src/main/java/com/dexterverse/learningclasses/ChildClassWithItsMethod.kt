package com.dexterverse.learningclasses

class ChildClassWithItsMethod : ParentClassWithItsMethod(),Singer {
    fun printIAmChildGenes() {
        println("I am child genes.");
    }

    override fun height() {
        super.height()
        println("Child height is 5 feet.")
    }

    override fun sing(){
        super.sing()
        println("YO YO i am a singer too.")
    }

}