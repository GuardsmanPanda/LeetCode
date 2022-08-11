package Problem2300;

import java.util.Arrays;

public class Problem2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Arrays.sort(ranks);
        Arrays.sort(suits);
        if (suits[0] == suits[4]) {
            return "Flush";
        }
        if (ranks[0] == ranks[2] || ranks[1] == ranks[3] || ranks[2] == ranks[4]) {
            return "Three of a Kind";
        }
        if (ranks[0] == ranks[1] || ranks[1] == ranks[2] || ranks[2] == ranks[3] || ranks[3] == ranks[4]) {
            return "Pair";
        }
        return "High Card";
    }
}
