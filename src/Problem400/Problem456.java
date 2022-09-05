package Problem400;

public class Problem456 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int[] stack = new int[nums.length];
        int index = -1, k = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num > k) {
                while (index > -1 && num > stack[index])
                    k = stack[index--];
                stack[++index] = num;
            }
            else if (num < k) return true;
        }
        return false;
    }
}
