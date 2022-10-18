package Problem2400;

import java.util.Set;

public class Problem2442 {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> found = new java.util.HashSet<>();
        for (int num : nums) {
            found.add(num);
            int rev = 0;
            while (num > 0) {
                rev = rev * 10 + num % 10;
                num /= 10;
            }
            found.add(rev);
        }
        return found.size();
    }
}
