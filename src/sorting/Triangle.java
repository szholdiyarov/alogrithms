package sorting;

import java.math.BigInteger;
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
        String[] unsorted = {"10", "3", "5", "4", "1"};
        // your code goes here
        for (int i = 0; i < unsorted.length; i++) {
            BigInteger currentNumber = new BigInteger(unsorted[i]);
            BigInteger minimumNumber = currentNumber;
            int minimumNumberPosition = i;
            for (int j = i + 1; j < unsorted.length; j++) {
                BigInteger anotherNumber = new BigInteger(unsorted[j]);
                if (anotherNumber.compareTo(minimumNumber) == -1) {
                    minimumNumber = anotherNumber;
                    minimumNumberPosition = j;
                }
            }
            unsorted[minimumNumberPosition] = unsorted[i];
            unsorted[i] = minimumNumber.toString();
            System.out.println(unsorted[i]);
        }

//        int[] andrea = {2, 4, 5, 6, 7};
//        int[] maria = {3, 8, 10, 12, 14};
//        String gameType = "Even";
//        System.out.println(winner(andrea, maria, gameType));

        int[] a = {7, 10, 7};
        int[] b = {2, 3, 4};
        int[] c = {2, 7, 4};

        System.out.println(Arrays.toString(triangleOrNot(a,b,c)));
    }

    /*
     * Complete the function below.
     */
    static String winner(int[] andrea, int[] maria, String s) {
        int andreaScores = 0;
        int mariaScores = 0;

        for (int i = 0; i < andrea.length; i++) {

            if (s.equalsIgnoreCase("even") && (i % 2) == 0) {
                andreaScores = andreaScores + (andrea[i] - maria[i]);
                mariaScores = mariaScores + (maria[i] - andrea[i]);
            }

            if (s.equalsIgnoreCase("odd") && (i % 2) != 0) {
                andreaScores = andreaScores + (andrea[i] - maria[i]);
                mariaScores = mariaScores + (maria[i] - andrea[i]);
            }
        }

        if (andreaScores > mariaScores) {
            return "Andrea";
        } else if (andreaScores == mariaScores) {
            return "Tie";
        } else {
            return "Maria";
        }
    }

    /*
     * Complete the function below.
     */
    static String[] triangleOrNot(int[] a, int[] b, int[] c) {
        if (a.length != b.length && b.length != c.length && a.length != c.length) {
            return new String[0];
        }

        int N = a.length;
        String[] result = new String[N];

        for (int i = 0; i < N; i++) {
            int A = a[i];
            int B = b[i];
            int C = c[i];
            if (((A + B) > C) && ((B + C) > A) && ((C + A) > B)) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }

        return result;
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
