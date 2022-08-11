package Problem2300;

public class Problem2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] found = new boolean[201];
        int res = 0;
        for (int num : nums) {
            found[num] = true;
            if (num >= diff * 2 && found[num - diff] && found[num - diff - diff]) {
                res++;
            }
        }
        return res;
    }
}
