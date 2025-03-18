package com.example.kotlinbasics

fun main() {
    val output = Classes07(name = "Rishit", 4)
    val petProperties = "${output.name} has ${output.legs} legs."
    println(petProperties)
    println("Changed my pet name.")
    output.name = "Priya"
    val petPropertiesAfterAYear = "${output.name} has ${output.legs} legs."
    println(petPropertiesAfterAYear)


    val dogProperties: String = output.dog();
    println(dogProperties)
}