package Problem2400;

public class Problem2439 {
    public int minimizeArrayValue(int[] nums) {
        long max = 0, sum = 0, count = 0;
        for (int num : nums) {
            max = Math.max(max, ((sum += num) + count) /++ count);
        }
        return (int) max;
    }
}
