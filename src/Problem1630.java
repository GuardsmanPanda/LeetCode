import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        outer:
        for (int i = 0; i < l.length; i++) {
            int left = l[i], right = r[i];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int j = left; j <= right; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
            }
            System.out.println("left: " + left + " right: " + right + " min: " + min + " max: " + max);
            if (min == max) {
                result.add(true);
                continue;
            }
            if ((max - min) % (right - left) != 0) {
                result.add(false);
            } else {
                HashSet<Integer> seen = new HashSet<>();
                for (int j = left; j <= right; j++) {
                    seen.add(nums[j]);
                }
                int inc = (max - min) / (right - left);
                for (int n = min; n <= max; n += inc) {
                    if (!seen.contains(n)) {
                        result.add(false);
                        continue outer;
                    }
                }
                result.add(true);
            }
        }
        return result;
    }
}
