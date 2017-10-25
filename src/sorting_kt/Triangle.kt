package sorting_kt

import java.util.*

/**
 * Created by szholdiyarov on 10/25/17.
 * <p>
 * A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 * <p>
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 * <p>
 * A[0] = 10    A[1] = 2    A[2] = 5
 * A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 * <p>
 * Write a function:
 * <p>
 * int solution(int A[], int N);
 * that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 */

fun main(args: Array<String>) {
    val numbers = arrayOf(2, 1, 1, 2, 3, 1)
}

fun solution(A: IntArray, N: Int): Int {
    if (A.size < 3) return 0

    Arrays.sort(A)

    for (i in 2..A.size - 1) {
        if (A[i - 2] + A[i - 1] > A[i]) return 1
    }
    return 0
}

