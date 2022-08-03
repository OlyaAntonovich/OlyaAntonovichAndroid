package com.example.calculator

import kotlin.math.roundToInt

fun main() {

    print("Введите выражение, которое необходимо посчитать  ")

    val nameValue: String? = readLine()

    val сalculatorMainFunctions = CalculatorMainFunctions()

    val calculator = Calculator()

    val result = nameValue?.let { calculator.calculateWithBrackets(сalculatorMainFunctions, it) }

    println("Вы получите: $result")

}



