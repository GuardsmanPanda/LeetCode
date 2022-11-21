package Problem500;

import java.util.Arrays;

public class Problem568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[] nextVacation = new int[flights.length], vacation = new int[flights.length];
        Arrays.fill(vacation, Integer.MIN_VALUE);
        vacation[0] = 0;
        for (int k = 0; k < days[0].length; k++) {
            Arrays.fill(nextVacation, Integer.MIN_VALUE);
            for (int i = 0; i < vacation.length; i++) {
                if (vacation[i] == Integer.MIN_VALUE) {
                    continue;
                }
                for (int j = 0; j < flights.length; j++) {
                    if (i == j || flights[i][j] == 1) {
                        nextVacation[j] = Math.max(nextVacation[j], vacation[i] + days[j][k]);
                    }
                }
            }
            int[] temp = vacation;
            vacation = nextVacation;
            nextVacation = temp;
        }
        return Arrays.stream(vacation).max().getAsInt();
    }
}
