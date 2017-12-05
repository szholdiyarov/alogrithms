package binary_search

import java.util.*

/**
 * Created by szholdiyarov on 12/5/17.
 *
 * Time complexity : O(LogN)
 */
fun main(args: Array<String>) {
    val expression = arrayOf(10, 54, 23, 56, 78, 22, 34, 44, 55, 21, 58, 2, 5)
    println("result is ${binarySearch(expression, 2)}")
}

/**
 * Returns position of the search element if exists, -1 otherwise
 */
fun binarySearch(expression: Array<Int>, searchValue: Int): Int {
    expression.sort()
    println(Arrays.toString(expression))

    var lowerIndex = 0
    var upperIndex = expression.size - 1

    while ((lowerIndex != upperIndex) && (lowerIndex >= 0) && (upperIndex >= 0)) {
        val middleIndex = (upperIndex + lowerIndex) / 2
        val currentElement = expression[middleIndex]

        if (currentElement == searchValue) {
            return middleIndex
        } else if (currentElement > searchValue) {
            upperIndex = middleIndex
        } else if (currentElement < searchValue) {
            if (lowerIndex == middleIndex)
                lowerIndex++
            else
                lowerIndex = middleIndex
        }
    }

    return -1
}