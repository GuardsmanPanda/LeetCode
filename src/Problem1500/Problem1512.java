package Problem1500;

public class Problem1512 {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int res = 0;
        for (int i : nums) {
            res += count[i]++;
        }
        return res;
    }
}
