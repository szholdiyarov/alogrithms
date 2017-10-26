package sorting;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by szholdiyarov on 10/25/17.
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * https://www.hackerrank.com/challenges/mini-max-sum
 */

public class MiniMaxSum {
    public static void main(String[] args) {
        int[] testValues = {1, 2, 3, 4, 5};
        printMaxAndMinTotalValues(testValues);

    }

    private static void printMaxAndMinTotalValues(int[] array) {
        Arrays.sort(array);

        int max = array[4] + array[3] + array[2] + array[1];
        int min = array[0] + array[1] + array[2] + array[3];

        System.out.println(min + " " + max);
    }
}
