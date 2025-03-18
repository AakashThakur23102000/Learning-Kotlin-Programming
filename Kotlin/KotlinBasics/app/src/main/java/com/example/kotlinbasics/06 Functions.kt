package com.example.kotlinbasics

fun main() {
    print("Enter the numbers of coffee cups - ")
    val mugs = readln().toInt()

    val output: String = makeCoffee(mugs)
    println(output)
}

fun makeCoffee(mugs: Int): String {
    println("Make a Coffee")
    return "No of coffees made - $mugs"
}