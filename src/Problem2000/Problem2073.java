package Problem2000;

import java.util.ArrayDeque;

public class Problem2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int want = tickets[k];
        int total = want;
        for(int i = 0; i < tickets.length; i++) {
            if(i < k) {
                total += Math.min(tickets[i], want);
            } else if(i > k) {
                total += Math.min(tickets[i], want-1);
            }
        }
        return total;
    }
}
