package cakes

import java.util.*

/**
 * Created by szholdiyarov on 12/6/17.
 *
 * Suppose we could access yesterday's stock prices as an array, where:

 * The indices are the time in minutes past trade opening time, which was 9:30am local time.
 * The values are the price in dollars of Apple stock at that time.
 * So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

 * Write an efficient method that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
 */
fun main(args: Array<String>) {
    val expression = arrayOf(11, 7, 9, 8, 10, 5)
    println(Arrays.toString(expression))
    println(getMaxProfit(expression))
}

// Time Complexity : O(n)
fun getMaxProfit(stockPriceYesterday: Array<Int>): Int {
    var maxIndex = 0
    var minIndex = 0

    var maxValue = stockPriceYesterday[0]
    var minValue = stockPriceYesterday[0]

    var counter = -1
    stockPriceYesterday.forEach {
        counter++

        if (it < minValue) {
            if (counter + 1 != stockPriceYesterday.size) {
                minValue = it
                minIndex = counter
                maxIndex = -1
                maxValue = 0
            }
        } else if (it > maxValue) {
            maxValue = it
            maxIndex = counter
        }
    }

    if (maxIndex > -1)
        return stockPriceYesterday[maxIndex] - stockPriceYesterday[minIndex]
    else return 0
}



