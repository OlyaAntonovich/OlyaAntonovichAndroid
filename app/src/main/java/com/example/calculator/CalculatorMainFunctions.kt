package com.example.calculator

import kotlin.math.roundToInt
import kotlin.math.roundToLong


interface Functions {
    fun countPlusExpression(str: String): Double
    fun countMultiplyExpression(str: String): Double
    fun subtractFunction(str: String): Double
    fun countDivisionExpression(str: String): Double

}


open class CalculatorMainFunctions(

) : Functions {

    override fun countPlusExpression(str: String): Double {
        val matchResult1 = Regex("""([-]?[0-9]*\.?[0-9]*)[+]([-]?[0-9]*\.?[0-9]*)""").find(str)
        if (matchResult1 == null) return error("Incorrect function")
        val container = matchResult1.groupValues.drop(1).map { it.toDouble() }
        return container.sum()
    }

    override fun countMultiplyExpression(str: String): Double {
        val matchResult = Regex("""([-]?[0-9]*\.?[0-9]*)[*]([-]?[0-9]*\.?[0-9]*)""").find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        return container[0] * container[1]
    }

    override fun subtractFunction(str: String): Double {
        val matchResult = Regex("""([-]?[0-9]*\.?[0-9]*)[-]([-]?[0-9]*\.?[0-9]*)""").find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        return container[0] - container[1]
    }

    override fun countDivisionExpression(str: String): Double {
        val matchResult = Regex("""([-]?[0-9]*\.?[0-9])[/]([-]?[0-9]*\.?[0-9]*)""").find(str)
        if (matchResult == null) return error("Incorrect function")
        val container = matchResult.groupValues.drop(1).map { it.toDouble() }
        val evaluateValue = ((container[0]/container[1])*100.0).roundToInt()
        return ((evaluateValue)/100.0)
    }
}