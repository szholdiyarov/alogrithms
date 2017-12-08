package cakes

import java.util.*

/**
 * Created by szholdiyarov on 11/28/17.
 * Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and returns an array of the products.
 */

fun main(args: Array<String>) {
    val expression = arrayOf(1, 7, 3, 4)
    println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(expression)))
}

fun getProductsOfAllIntsExceptAtIndex(values: Array<Int>): Array<Int> {
    val resultArray = arrayOfNulls<Int>(values.size)

    for (i in 0..values.size - 1) {
        var firstHalf = 1
        var secondHalf = 1

        for (j in 0..i - 1) {
            firstHalf *= values[j]
        }

        for (j in i + 1..values.size - 1) {
            secondHalf *= values[j]
        }

        resultArray[i] = firstHalf * secondHalf
    }

    return resultArray as Array<Int>
}