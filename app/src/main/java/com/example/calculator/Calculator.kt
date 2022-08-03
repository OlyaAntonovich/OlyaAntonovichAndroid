package com.example.calculator

open class Calculator {

    fun calculateWithBrackets(inter: Functions, str: String): Double {
        val matcherGroup =
            """(\([-]?[0-9]*\.?[0-9]*)[+]?[-]?[/]?[*]?([-]?[0-9]*\.?[0-9]*[+]?[-]?[/]?[*]?[-]?[0-9]*\.?[0-9]*?\))"""

        var newString = ""
        var result: Double
        var isFlag = true


        if (Regex(matcherGroup).containsMatchIn(str)) {

            var str1 = str

            while (isFlag) {

                val subString = calculate(inter, (Regex(matcherGroup).find(str1)?.value.toString()))
                val subString1 = subString.replace("(", "")
                val subString2 = subString1.replace(")", "")

                newString = str1.replaceFirst(
                    matcherGroup.toRegex(),
                    subString2
                )

                if (Regex(matcherGroup).containsMatchIn(newString)) {
                    str1 = newString
                    isFlag = true
                } else {
                    str1 = newString
                    isFlag = false
                }

            }

            result = calculate(inter, str1).toDouble()

        } else {
            result = calculate(inter, str).toDouble()
        }


        return result

    }

    fun calculate(inter: Functions, str: String): String {
        var newString = str
        var isFlag = true
        val matcherGroup1 = """([-]?[0-9]*\.?[0-9]*)[*]([-]?[0-9]*\.?[0-9]*)"""
        val matcherGroup2 = """([-]?[0-9]*\.?[0-9]*)[/]([-]?[0-9]*\.?[0-9]*)"""
        val matcherGroup3 = """([-]?[0-9]*\.?[0-9]*\b)[-]([-]?[0-9]*\.?[0-9]*)"""
        val matcherGroup4 = """([-]?[0-9]*\.?[0-9]*)[+]([-]?[0-9]*\.?[0-9]*)"""

        while (isFlag) {
            if (Regex(matcherGroup1).containsMatchIn(newString)) {

                var stringReplace = inter.countMultiplyExpression(newString).toString()

                newString =
                    newString.replaceFirst(
                        (matcherGroup1).toRegex(),
                        stringReplace
                    )


            } else if (Regex(matcherGroup2).containsMatchIn(
                    newString
                )
            ) {
                var stringReplace = inter.countDivisionExpression(newString).toString()

                newString.replaceFirst(
                    (matcherGroup2).toRegex(),
                    stringReplace
                )
                    .also { newString = it }

            } else if (Regex(matcherGroup3).containsMatchIn(
                    newString
                )
            ) {
                var stringReplace = inter.subtractFunction(newString).toString()
                newString =
                    newString.replaceFirst(
                        (matcherGroup3).toRegex(),
                        stringReplace
                    )

            } else if (Regex(matcherGroup4).containsMatchIn(
                    newString
                )
            ) {
                var stringReplace = inter.countPlusExpression(newString).toString()
                newString =
                    newString.replaceFirst(
                        (matcherGroup4).toRegex(),
                        stringReplace
                    )
            } else isFlag = false

        }

        return newString
    }

}