package stacks_and_queues_kt

import java.util.*


/**
 * Created by szholdiyarov on 10/30/17.
 * <p>
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * https://codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 */

class Nesting {

    private val PROPERLY_NESTED = 1
    private val NOT_PROPERLY_NESTED = 0
    private val OPEN_BRACETS = '('

    fun main(args: Array<String>) {
        val sampleTest = "(((()(())()))"
        println(solution(sampleTest))
    }

    private fun solution(S: String): Int {
        val openBrackets = ArrayDeque<Char>(S.length / 2)

        for (character in S.toCharArray()) {
            if (character === OPEN_BRACETS) {
                openBrackets.add(character)
            } else {
                if (openBrackets.isEmpty()) {
                    return NOT_PROPERLY_NESTED
                }
                openBrackets.poll()
            }
        }


        if (openBrackets.isEmpty()) {
            return PROPERLY_NESTED
        } else {
            return NOT_PROPERLY_NESTED
        }
    }
}
