package Problem1500;

public class Problem1558 {
    public int minOperations(int[] nums) {
        int count = 0, highest = 0;
        for (int num : nums) {
            count += Integer.bitCount(num);
            highest = Math.max(highest, Integer.highestOneBit(num));
        }
        while (highest > 1) {
            highest >>= 1;
            count++;
        }
        return count;
    }
}
