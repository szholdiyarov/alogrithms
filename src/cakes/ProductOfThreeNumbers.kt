package cakes

/**
 * Created by szholdiyarov on 12/8/17.
 * Given an array of integers, find the highest product you can get from three of the integers.
 */

fun main(args: Array<String>) {
    val expression = arrayOf(-10, -10, 1, 3, 2)
    println(getHighestProductOfThreeNumbers(expression))
}


fun getHighestProductOfThreeNumbers(values: Array<Int>): Int {
    values.sort()

    return Math.max(values[values.size - 3] * values[values.size - 2] * values[values.size - 1], values[0] * values[1] * values[values.size - 1])
}