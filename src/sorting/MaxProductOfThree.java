package sorting;

import java.util.Arrays;

/**
 * Created by szholdiyarov on 10/25/17.
 * Write a function:
 * <p>
 * int solution(int A[], int N);
 * that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.
 */
public class MaxProductOfThree {
    public static void main(String[] args) {
        int[] A = {-5, 1, 3, -11, -4};

        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }

    private static class Solution {
        public int solution(int[] A) {
            if (A.length < 3) return 0;
            int highest = 0;
            Arrays.sort(A);
            for (int i : A) {
                System.out.println(i);
            }

            if (A[0] < 0 && A[1] < 0) {
                highest = A[0] * A[1] * A[A.length - 1];
            }

            int P = A[A.length - 1];
            int Q = A[A.length - 2];
            int R = A[A.length - 3];

            int sum = P * Q * R;

            return Math.max(highest, sum);


        }
    }
}
