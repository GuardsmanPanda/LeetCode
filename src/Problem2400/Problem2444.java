package Problem2400;

public class Problem2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minCount = 0, maxCount = 0, left1 = 0, left2 = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < minK || n > maxK) {
                minCount = maxCount = 0;
                left1 = left2 = i + 1;
                continue;
            }
            minCount += n == minK ? 1 : 0;
            maxCount += n == maxK ? 1 : 0;
            while (left2 < i && nums[left2] != minK && nums[left2] != maxK || (nums[left2] == minK && minCount > 1) || (nums[left2] == maxK && maxCount > 1)) {
                minCount -= nums[left2] == minK ? 1 : 0;
                maxCount -= nums[left2] == maxK ? 1 : 0;
                left2++;
            }
            if (minCount > 0 && maxCount > 0) {
                res += left2 - left1 + 1;
            }
        }
        return res;
    }
}
