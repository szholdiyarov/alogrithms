package sorting;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by szholdiyarov on 10/25/17.
 * Colleen is turning  years old! Therefore, she has  candles of various heights on her cake, and candle  has height . Because the taller candles tower over the shorter ones, Colleen can only blow out the tallest candles.
 * <p>
 * Given the  for each individual candle, find and print the number of candles she can successfully blow out.
 * https://www.hackerrank.com/challenges/birthday-cake-candles?h_r=next-challenge&h_v=zen
 */

public class BithdayCakeCandles {
    public static void main(String[] args) {
        int[] testValues = {3, 2, 1, 3};
        System.out.println(birthdayCakeCandles(testValues.length, testValues));

    }

    private static int birthdayCakeCandles(int n, int[] ar) {
        int total = 1;

        Arrays.sort(ar);

        for (int i = ar.length - 2; i >= 0; i--) {
           if (ar[i] == ar[i + 1]){
               total ++;
           } else {
               break;
           }
        }

        return total;
    }
}
