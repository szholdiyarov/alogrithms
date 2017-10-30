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
        int[] testValues = {256741038, 623958417, 467905213, 714532089, 938071625};
        printMaxAndMinTotalValues(testValues);

    }

    private static void printMaxAndMinTotalValues(int[] array) {
        Arrays.sort(array);

        BigInteger max = BigInteger.valueOf(array[4]).add(BigInteger.valueOf(array[3])).add(BigInteger.valueOf(array[2]).add(BigInteger.valueOf(array[1])));
        BigInteger min = BigInteger.valueOf(array[0]).add(BigInteger.valueOf(array[1])).add(BigInteger.valueOf(array[2]).add(BigInteger.valueOf(array[3])));

        System.out.println(min + " " + max);
    }
}
