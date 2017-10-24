package sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by szholdiyarov on 10/24/17.
 * <p>
 * Compute number of distinct values in an array.
 * <p>
 * Task: Given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.
 */
public class Distinct {

    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.solution(A));
    }

    private static class Solution {

        public int solution(int[] A) {
            Set<Integer> set = new HashSet<>();
            set.addAll(Arrays.stream(A).boxed().collect(Collectors.toList()));
            return set.size();
        }
    }

}
