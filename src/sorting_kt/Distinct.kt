package sorting_kt

/**
 * Created by szholdiyarov on 10/24/17.
 * <p>
 * Compute number of distinct values in an array.
 * <p>
 * Task: Given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.
 */

fun main(args: Array<String>) {
    val numbers = arrayOf(2, 1, 1, 2, 3, 1)
    println(solution(numbers))
}

fun solution(numbers: Array<Int>): Int {
    val set = setOf(numbers)
    return set.size
}
