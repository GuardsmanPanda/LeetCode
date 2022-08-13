package Problem300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] length = new int[nums.length];
        int[] next = new int[nums.length];
        Arrays.sort(nums);
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % n == 0) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        next[i] = j;
                        if (length[i] > length[max]) {
                            max = i;
                        }
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[max]);
        while (next[max] != 0) {
            max = next[max];
            res.add(nums[max]);
        }
        return res;
    }
}
