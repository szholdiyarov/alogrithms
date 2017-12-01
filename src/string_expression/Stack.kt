package string_expression

import java.util.*

/**
 * Created by szholdiyarov on 11/28/17.
 */

class Stack<T : Comparable<T>>(list: MutableList<T>) : Iterator<T> {

    var itCounter: Int = 0

    var items: MutableList<T> = list


    fun isEmpty(): Boolean = this.items.isEmpty()

    fun count(): Int = this.items.count()

    fun push(element: T) {
        val position = this.count()
        this.items.add(position, element)
    }

    override fun toString() = this.items.toString()

    fun pop(): T? {
        if (this.isEmpty()) {
            return null
        } else {
            val item = this.items.count() - 1
            return this.items.removeAt(item)
        }
    }

    fun peek(): T? {
        if (isEmpty()) {
            return null
        } else {
            return this.items[this.items.count() - 1]
        }
    }

    override fun hasNext(): Boolean {
        val hasNext = itCounter < count()

        // As soon as condition fails, reset the counter
        if (!hasNext) itCounter = 0

        return hasNext
    }

    override fun next(): T {
        if (hasNext()) {
            val topPos: Int = (count() - 1) - itCounter
            itCounter++
            return this.items[topPos]
        } else {
            throw NoSuchElementException("No such element")
        }
    }

}