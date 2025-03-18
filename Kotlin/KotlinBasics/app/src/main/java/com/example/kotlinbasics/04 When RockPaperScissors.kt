package com.example.kotlinbasics

fun main() {
    print("Enter your choice - ")
    val input = readln()
    var comChoice: String = ""

    val randomNumber: Byte = (1..3).random().toByte()

    if (randomNumber == 1.toByte()) {
        comChoice = "Rock"
    } else if (randomNumber == 2.toByte()) {
        comChoice = "Paper"
    } else {
        comChoice = "Scissors"
    }

    println("My - $input")
    println("Computer - $comChoice")

    val output: String = when {
        input != "Rock" && input != "Paper" && input != "Scissors" -> "Wrong Input"
        input == comChoice -> "Tie"
        input == "Rock" && comChoice == "Scissors" -> "Player won"
        input == "Paper" && comChoice == "Rock" -> "Player won"
        input == "Scissors" && comChoice == "Paper" -> "Player won"
        else -> "Computer Won"
    }

    println(output)
}