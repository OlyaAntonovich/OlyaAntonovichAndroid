package com.example.calculator

import kotlin.math.roundToInt

fun main() {

    print("Введите выражение, которое необходимо посчитать  ")

    val name: String? = readLine()

    val сalculatorMainFunctions = CalculatorMainFunctions()

    val calculator = Calculator()

    val result = name?.let { calculator.calculateWithBrackets(сalculatorMainFunctions, it) }

    println("Вы получите: $result")

}



