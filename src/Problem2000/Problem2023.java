package Problem2000;

public class Problem2023 {
    public int numOfPairs(String[] nums, String target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target.equals(nums[i] + nums[j])) {
                    res++;
                }
                if (target.equals(nums[j] + nums[i])) {
                    res++;
                }
            }
        }
        return res;
    }
}
