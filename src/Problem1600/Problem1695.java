package Problem1600;

public class Problem1695 {
    public int maximumUniqueSubarray(int[] nums) {
        boolean[] found = new boolean[10001];
        int res = 0, cur = 0;
        for (int i = 0, left = 0; i < nums.length; i++) {
            if (!found[nums[i]]) {
                found[nums[i]] = true;
                cur += nums[i];
            } else {
                while (nums[left] != nums[i]) {
                    found[nums[left]] = false;
                    cur -= nums[left++];
                }
                left++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
