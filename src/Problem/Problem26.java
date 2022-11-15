package Problem;

public class Problem26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int pairDown = 0;
        int lastnum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (lastnum == nums[i]) pairDown++;
            else {
                nums[i - pairDown] = nums[i];
                lastnum = nums[i];
            }
        }
        return nums.length - pairDown;
    }
}
