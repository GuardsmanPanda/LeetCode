package Problem2400;

public class Problem2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMinK = -1, lastMaxK = -1, lastOutsideBound = -1;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v < minK || v > maxK) {
                lastOutsideBound = i;
                lastMaxK = i;
                lastMinK = i;
            }
            if (v == minK) {
                lastMinK = i;
            }
            if (v == maxK) {
                lastMaxK = i;
            }
            ans += Math.min(lastMinK, lastMaxK) - lastOutsideBound;
        }
        return ans;
    }
}
