package Problem2000;

import java.util.Arrays;

public class Problem2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(students);
        Arrays.sort(seats);
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
