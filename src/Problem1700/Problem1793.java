package Problem1700;

public class Problem1793 {
    public int maximumScore(int[] nums, int k) {
        int maxScore = nums[k], minElement = nums[k];
        int left = k, right = k;
        while (left > 0 || right < nums.length - 1) {
            if (left == 0) {
                right++;
            } else if (right == nums.length - 1) {
                left--;
            } else if (nums[left - 1] < nums[right + 1]) {
                right++;
            } else {
                left--;
            }
            minElement = Math.min(minElement, Math.min(nums[left], nums[right]));
            maxScore = Math.max(maxScore, minElement * (right - left + 1));
        }
        return maxScore;
    }
}
