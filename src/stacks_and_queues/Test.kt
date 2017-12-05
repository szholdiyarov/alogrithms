package stacks_and_queues

import java.util.*

/**
 * Created by szholdiyarov on 12/5/17.
 */
fun main(args: Array<String>) {
    var expressions = arrayOf("<>", "<>><")
    val maxReplacements = arrayOf(1, 0)

    var result = balancedOrNot(expressions, maxReplacements)
    result.forEach {
        println(it)
    }
}

private val BALANCED = 1
private val NOT_BALANCED = 0

/*
 * Complete the function below.
 */
fun balancedOrNot(expressions: Array<String>, maxReplacements: Array<Int>): Array<Int> {
    val result = arrayOfNulls<Int>(expressions.size)

    var counter = 0
    expressions.forEach {
        counter += 1
        if (isExpressionBalansed(it)) {
            result[counter - 1] = BALANCED
        } else {
            val balanced = tryToBalanceExpression(it, maxReplacements[counter - 1])
            if (isExpressionBalansed(balanced)) {
                result[counter - 1] = BALANCED
            } else {
                result[counter - 1] = NOT_BALANCED
            }
        }
    }

    return result as Array<Int>
}

private fun tryToBalanceExpression(expression: String, maxReplacement: Int): String {
    val builder = StringBuilder(expression)
    var replacementCounter = 0

    val openBrackets = ArrayDeque<Char>(expression.length / 2)
    var i = 0
    var numberOfIterations = expression.length
    while (i < numberOfIterations) {
        val character = builder[i]
        if (character === '<') {
            openBrackets.add(character)
        } else {
            if (openBrackets.isEmpty()) {
                if (replacementCounter < maxReplacement) {
                    builder.replace(i, i + 1, "<>")
                    i += 1
                    numberOfIterations++
                    replacementCounter++
                }
            }
            openBrackets.poll()
        }
        i++
    }

    return builder.toString()
}


private fun isExpressionBalansed(expression: String): Boolean {
    val openBrackets = ArrayDeque<Char>(expression.length / 2)

    for (character in expression.toCharArray()) {
        if (character === '<') {
            openBrackets.add(character)
        } else {
            if (openBrackets.isEmpty()) {
                return false
            }
            openBrackets.poll()
        }
    }


    if (openBrackets.isEmpty()) {
        return true
    } else {
        return false
    }
}