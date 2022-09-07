package Problem2000;

public class Problem2016 {
    public int maximumDifference(int[] nums) {
        int res = 0, min = nums[0];
        for (int num : nums) {
            res = Math.max(res, num - min);
            min = Math.min(min, num);
        }
        return res == 0 ? -1 : res;
    }
}
