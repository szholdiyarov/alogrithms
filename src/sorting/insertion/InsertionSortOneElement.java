package sorting.insertion;

import java.util.Arrays;

/**
 * Created by szholdiyarov on 10/26/17.
 */
public class InsertionSortOneElement {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 5, 6, 3};
        insertIntoSorted(A);
        System.out.println(Arrays.toString(A));
    }


    private static void insertIntoSorted(int[] ar) {
        int unsortedElement = ar[ar.length - 1];
        for (int i = ar.length - 2; i >= 0; i--) {
            int currentValue = ar[i];
            if (currentValue > unsortedElement) {
                ar[i + 1] = ar[i];
                ar[i] = unsortedElement;
                System.out.println(Arrays.toString(ar));
            } else{
                return;
            }
        }

    }

}
