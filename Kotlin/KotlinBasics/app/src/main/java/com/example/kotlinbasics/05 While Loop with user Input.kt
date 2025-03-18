package com.example.kotlinbasics

fun main() {
    print("Enter a number to print range - ")
    var result: Long = readln().toLong();
    var startNumber: Long = 0

    while (startNumber <= result) {
        println(startNumber)
        startNumber++
    }
}