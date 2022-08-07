import java.util.Arrays;

public class Problem2172 {
    private int[] score;
    private int[] nums;
    private int numSlots;

    public int maximumANDSum(int[] nums, int numSlots) {
        score = new int[1 << (numSlots * 2)];
        Arrays.fill(score, -1);
        this.numSlots = numSlots;
        this.nums = nums;
        return getScore(0,0);
    }

    private int getScore(int idx, int state) {
        if (idx == nums.length) {
            return 0;
        }
        if (score[state] != -1) {
            return score[state];
        }
        int n = nums[idx];
        //System.out.println("idx: " + idx + " state: " + Integer.toBinaryString(state) + " n: " + n);
        for (int i = 0; i < numSlots; i++) {
            int target = 1 << i;
            int target2 = 1 << (i + numSlots);
            if ((state & target) == 0) {
                score[state] = Math.max(score[state], getScore(idx + 1, state | target) + (n & (i+1)));
            } else if ((state & target2) == 0) {
                score[state] = Math.max(score[state], getScore(idx + 1, state | target2) + (n & (i+1)));
            }
        }
        return score[state];
    }
}
