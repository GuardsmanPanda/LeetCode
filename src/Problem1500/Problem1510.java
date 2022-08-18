package Problem1500;

import java.util.ArrayList;
import java.util.List;

public class Problem1510 {
    public boolean winnerSquareGame(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        boolean[] starterWins = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (Integer square : squares) {
                if (square > i)  {
                    break;
                }
                if (!starterWins[i - square]) {
                    starterWins[i] = true;
                    break;
                }
            }
        }
        return starterWins[n];
    }
}
