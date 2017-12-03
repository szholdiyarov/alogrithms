package cakes

import com.sun.org.apache.xpath.internal.operations.Bool
import string_expression.infixToPostfix
import java.util.*

/**
 * Created by szholdiyarov on 11/28/17.
 * Users on longer flights like to start a second movie right when their first one ends, but they complain that the plane usually lands before they can see the ending.
 * So you're building a feature for choosing two movies whose total runtimes will equal the exact flight length.
 */


fun main(args: Array<String>) {

    val exampleMoviesLength = arrayOf(10, 25, 30, 120, 43, 500, 92, 20, 123, 23, 50)
    val exampleFlightLength = 100

    println(chooseTwoMovies(exampleFlightLength, exampleMoviesLength))

}

fun chooseTwoMovies(flightLength: Int, moviesLength: Array<Int>): Boolean {
    return moviesLength.filter { it == flightLength / 2 }.size >= 2
}

fun chooseTwoMoviesExtended(flightLength: Int, moviesLength: Array<Int>): Boolean {
    moviesLength.sort()
    var moviesCounter = 0

    for (i in moviesLength.size - 1 downTo 0) {
        val movieLength = moviesLength[i]
        if (movieLength == flightLength / 2) {
            moviesCounter += 1
        }
    }

    return moviesCounter >= 2
}

