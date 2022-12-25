package Problem2400;

import java.util.Arrays;

public class Problem2498 {
    public int maxJump(int[] stones) {
        int low = 0, high = stones[stones.length - 1] - stones[0];
        while (low < high) {
            int mid = (low + high) / 2;
            System.out.println("test " + mid);
            boolean[] visited = new boolean[stones.length];
            if (canJump(stones, mid, visited) && canJump(stones, mid, visited)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canJump(int[] stones, int jump, boolean[] used) {
        int target = stones[stones.length - 1];
        int curTarget = 0, nextIdx = 0;
        for (int i = 1; i < stones.length - 1 && curTarget < target; i++) {
            int pos = stones[i];
            if (pos > curTarget) {
                if (pos > stones[nextIdx] + jump) {
                    return false;
                }
                curTarget = stones[nextIdx] + jump;
                used[nextIdx] = true;
            }
            if (!used[i]) {
                nextIdx = i;
            }
        }
        if (curTarget < target) {
            curTarget = stones[nextIdx] + jump;
            used[nextIdx] = true;
        }
        return curTarget >= target;
    }
}
