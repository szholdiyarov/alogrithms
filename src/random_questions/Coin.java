package random_questions;

import java.util.*;

/**
 * Created by szholdiyarov on 11/8/17.
 * Write a function that, given:
 * <p>
 * an amount of money
 * a list of coin denominations
 * computes the number of ways to make the amount of money with coins of the available denominations.
 */
public class Coin {
    public static void main(String[] args) {
        System.out.println(solution(2, "1A 2F 1C"));
    }

    private static final int LEFT_END_ROW_NUMBER = 3;
    private static final int RIGHT_END_ROW_NUMBER = 10;
    private static final int MIDDLE_ROW_NUMBER = 7;
    private static final int THREE_SEQ_SEATS = 3;

    public static int solution(int N, String S) {
        // Initialization of all available seats
        List<Map<String, Boolean>> allSeats = new ArrayList<>(N);
        for (int i = 0; i <= N - 1; i++) {
            Map<String, Boolean> row = new LinkedHashMap<>();
            row.put("A", false);
            row.put("B", false);
            row.put("C", false);
            row.put("D", false);
            row.put("E", false);
            row.put("F", false);
            row.put("G", false);
            row.put("H", false);
            row.put("J", false);
            row.put("K", false);
            allSeats.add(row);
        }

        // Reserve seats if any
        if (!S.isEmpty()){
            String[] reservedSeats = S.split("\\s+");
            for (int i = 0; i < reservedSeats.length; i++) {
                String seatLetter = reservedSeats[i].replaceAll("[^A-Z]+", "");
                String rowNumber = reservedSeats[i].replaceAll("\\D+", "");
                allSeats.get(Integer.parseInt(rowNumber) - 1).put(seatLetter, true);
            }
        }

        // Actual count how many families can seat in three seats
        int totalCounter = 0;
        for (int i = 0; i < allSeats.size(); i++) {
            Map<String, Boolean> row = allSeats.get(i);

            int availableSeatsCounter = 0;
            int seatNumberInRow = 0;

            for (Map.Entry<String, Boolean> entry : row.entrySet()) {
                seatNumberInRow += 1;
                boolean isReserved = entry.getValue();
                if (!isReserved) {
                    availableSeatsCounter += 1;
                } else {
                    if (seatNumberInRow == 5 || seatNumberInRow == 6) { // if in the middle of the row
                        availableSeatsCounter = 0;
                    }
                }
                if ((seatNumberInRow == LEFT_END_ROW_NUMBER || seatNumberInRow == RIGHT_END_ROW_NUMBER)) { // check if seats were in the start or end of the row
                    if (availableSeatsCounter == THREE_SEQ_SEATS)
                        totalCounter += 1;
                    availableSeatsCounter = 0;
                } else if (seatNumberInRow == MIDDLE_ROW_NUMBER) { // check if seats were in the middle part of the row
                    if (availableSeatsCounter >= THREE_SEQ_SEATS)
                        totalCounter += 1;
                    availableSeatsCounter = 0;
                }
            }
        }

        return totalCounter;
    }
}
