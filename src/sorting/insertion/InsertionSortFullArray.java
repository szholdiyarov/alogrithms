package sorting.insertion;

/**
 * Created by szholdiyarov on 10/26/17.
 * You already can place an element into a sorted array. How can you use that code to build up a sorted array, one element at a time? Note that in the first step, when you consider an array with just the first element - that is already "sorted" since there's nothing to its left that is smaller.
 * <p>
 * https://www.hackerrank.com/challenges/insertionsort2
 */
public class InsertionSortFullArray {

    public static void main(String[] args) {
        int[] array = {5, 3, 6, 8, 7, 1};
        insertionSortPart2(array);
    }

    public static void insertionSortPart2(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            int valueToBeSorted = ar[i];
            for (int j = i; j >= 0; j--) {
                int valueToBeCompared = ar[j];
                if (valueToBeSorted < valueToBeCompared) {
                    ar[j] = valueToBeSorted;
                    ar[i] = valueToBeCompared;
                    i--;
                }
            }
        }
    }


    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
