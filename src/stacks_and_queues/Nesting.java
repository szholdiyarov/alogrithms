package stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by szholdiyarov on 10/30/17.
 * <p>
 * A string S consisting of N characters is called properly nested if:
 * <p>
 * S is empty;
 * S has the form "(U)" where U is a properly nested string;
 * S has the form "VW" where V and W are properly nested strings.
 * For example, string "(()(())())" is properly nested but string "())" isn't.
 * <p>
 * https://codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 */
public class Nesting {

    private static final int PROPERLY_NESTED = 1;
    private static final int NOT_PROPERLY_NESTED = 0;
    private static final Character OPEN_BRACETS = '(';

    public static void main(String[] args) {
        String sampleTest = "(((()(())()))";
        System.out.println(solution(sampleTest));
    }

    private static int solution(String S) {
        Queue<Character> openBrackets = new ArrayDeque<>(S.length() / 2);

        for (Character character : S.toCharArray()) {
            if (character == OPEN_BRACETS) {
                openBrackets.add(character);
            } else {
                if (openBrackets.isEmpty()) {
                    return NOT_PROPERLY_NESTED;
                }
                openBrackets.poll();
            }
        }


        if (openBrackets.isEmpty()) {
            return PROPERLY_NESTED;
        } else {
            return NOT_PROPERLY_NESTED;
        }
    }
}
