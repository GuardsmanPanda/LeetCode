package Problem1700;

public class Problem1746 {
    public int maxSumAfterOperation(int[] nums) {
        int maxSumWithout = 0;
        int maxSum = 0;
        int maxRes = 0;
        for (int num : nums) {
            maxSum = Math.max(maxSum + num, maxSumWithout + num*num);
            maxSumWithout = Math.max(maxSumWithout + num, 0);
            maxRes = Math.max(maxRes, maxSum);
        }
        return maxRes;
    }
}
