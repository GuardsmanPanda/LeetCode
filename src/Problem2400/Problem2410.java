package Problem2400;

import java.util.Arrays;

public class Problem2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(trainers);
        Arrays.sort(players);
        int res = 0, idx = players.length - 1;
        for (int i = trainers.length - 1; i >= 0; i--) {
            while (idx >= 0 && players[idx] > trainers[i]) {
                idx--;
            }
            if (idx >= 0) {
                idx--;
                res++;
            }
        }
        return res;
    }
}
