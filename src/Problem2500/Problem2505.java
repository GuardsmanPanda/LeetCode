package Problem2500;

public class Problem2505 {
    public long subsequenceSumOr(int[] nums) {
        long result = 0, prefix = 0;
        for (int num : nums) {
            prefix += num;
            result |= num;
            result |= prefix;
        }
        return result;
    }
}
