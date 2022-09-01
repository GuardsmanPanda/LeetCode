package Problem2300;

import java.util.Arrays;
import java.util.Comparator;

public class Problem2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        Arrays.sort(q, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(nums);
        int count = 0;
        long sum = 0;
        for (int[] ints : q) {
            int index = ints[1];
            int val = ints[0];
            while (count < nums.length && sum + nums[count] <= val) {
                sum += nums[count];
                count++;
            }
            res[index] = count;
        }
        return res;
    }
}
