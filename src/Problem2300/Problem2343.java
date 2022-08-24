package Problem2300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[][] index = new int[nums[0].length() + 1][nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[0][i] = i;
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 1; i <= nums[0].length(); i++) {
            for (int j = 0; j < nums.length; j++) {
                int idx = index[i - 1][j];
                buckets.get(nums[idx].charAt(nums[0].length() - i) - '0').add(idx);
            }
            int ndx = 0;
            for (int k = 0; k < 10; k++) {
                for (Integer val : buckets.get(k)) {
                    index[i][ndx++] = val;
                }
                buckets.get(k).clear();
            }
           // System.out.println(Arrays.toString(index[i]));
        }
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int order = queries[i][0];
            int trim = queries[i][1];
            output[i] = index[trim][order - 1];
        }
        return output;
    }
}
