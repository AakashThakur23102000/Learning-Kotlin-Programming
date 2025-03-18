package com.example.kotlinbasics

fun main() {
    //Immutable list - Static List
    val myImmutableList: List<String> = listOf("A", "B", "C")
    println("My Immutable List -  $myImmutableList")

    //Mutable List - Dynamic List
    val myMutableList: MutableList<String> = mutableListOf("1", "2", "3", "4")
    println("My Mutable List -  $myMutableList")

    myMutableList.add("5")
    println("After Changes - $myMutableList")

    myMutableList.add(1, "5")
    println("After Changes - $myMutableList")
}