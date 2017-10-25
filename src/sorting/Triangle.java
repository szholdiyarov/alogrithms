package sorting;

import java.util.Arrays;

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
public class Triangle {

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        Solution solution = new Solution();
        System.out.println(solution.solution(A, A.length));
    }

    private static class Solution {
        public int solution(int[] A, int N) {
            if (A.length < 3) return 0;

            Arrays.sort(A);

            for (int i = 2; i < A.length; i++) {
                if (A[i - 2] + A[i - 1] > A[i]) return 1;
            }
            return 0;
        }
    }


}
