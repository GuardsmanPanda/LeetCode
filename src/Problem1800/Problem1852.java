package Problem1800;

public class Problem1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] count = new int[100001];
        int distinct = 0;
        for (int i = 0; i < k - 1; i++) {
            if (count[nums[i]]++ == 0) {
                distinct++;
            }
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            if (count[nums[i]]++ == 0) {
                distinct++;
            }
            result[i - k + 1] = distinct;
            if (--count[nums[i - k + 1]] == 0) {
                distinct--;
            }
        }
        return result;
    }
}
