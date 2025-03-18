package com.example.kotlinbasics

fun main() {
    print("Enter your age - ")
    val input = readln()
    val age: Byte = input.toByte()

    if (age < 10) {
        println("Its a child.")
    } else if (age < 18) {
        println("Its a minor.")
    } else {
        println("Ready to dive.")
    }
}