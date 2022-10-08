package Problem2400;

public class Problem2422 {
    public int minimumOperations(int[] nums) {
        int left = 0, right = nums.length - 1;
        int res = 0;
        while (left <= right) {
            int sum = nums[left++];
            sum -= nums[right--];
            System.out.println("left: " + left + ", right: " + right + ", sum: " + sum);
            while (sum != 0 && left <= right) {
                sum += sum > 0 ? -nums[right--] : nums[left++];
                res++;
                System.out.println("left: " + left + ", right: " + right + ", sum: " + sum + ", res: " + res);
            }
            if (sum != 0) {
                res++;
            }
        }
        return res;
    }
}
