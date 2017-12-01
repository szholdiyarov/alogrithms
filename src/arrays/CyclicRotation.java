package arrays;

import java.util.Arrays;

/**
 * Created by szholdiyarov on 10/30/17.
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[] sampleTest = {3, 8, 9, 7, 6};
        System.out.println(Arrays.toString(solution(sampleTest, 1)));
    }


    public static int[] solution(int[] A, int K) {
        if (K == 0) {
            return A;
        }

        int last = A[A.length - 1];
        int first = A[0];

        A[last] = first;
        A[first] = last;

        for (int i = 1; i < A.length - 2; i++) {

        }

        return solution(A, K - 1);
    }


}
