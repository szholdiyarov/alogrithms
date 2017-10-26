package sorting.insertion;

/**
 * Given a sorted list with an unsorted number  in the rightmost cell, can you write some simple code to insert  into the array so that it remains sorted?
 */

public class Part1 {
    public static void main(String[] args) {
        int[] A = {2, 4, 6, 8, 3};
        insertIntoSorted(A);
    }

    public static void insertIntoSorted(int[] ar) {
        int unsortedValue = ar[ar.length - 1];
        for (int i = ar.length - 2; i >= 0; i--) {
            int currentValue = ar[i];
            System.out.println(i + " and " + currentValue);

            if (currentValue < unsortedValue) {

            } else {

            }
        }
    }

}
