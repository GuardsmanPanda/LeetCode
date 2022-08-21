package Problem2200;

public class Problem2239 {
    public int findClosestNumber(int[] nums) {
        int val = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        for (int num : nums) {
            int nd = Math.abs(num);
            if (dist > nd || (dist == nd && num > val)) {
                val = num;
                dist = nd;
            }
        }
        return val;
    }
}
