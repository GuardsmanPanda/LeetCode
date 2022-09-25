package Problem2300;

public class Problem2393 {
    public long countSubarrays(int[] nums) {
        long res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            int tmp = 0;
            while (j < nums.length -1 && nums[j] < nums[j + 1]) {
                res += ++tmp;
                j++;
            }
            i = j;
        }
        return res;
    }
}
