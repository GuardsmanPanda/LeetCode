package Problem800;

import java.util.Arrays;

public class Problem823 {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);
        int res = 0;
        long[] ways = new long[arr.length];
        Arrays.fill(ways, 1);
        for (int i = 0; i < ways.length; i++) {
            int target = arr[i];
            int left = 0, right = i - 1;
            while (left <= right) {
                long cur = (long)arr[left] * arr[right];
                if (cur == target) {
                    ways[i] += left == right ? (ways[left] * ways[right]) : (ways[left] * ways[right] * 2);
                    ways[i] %= mod;
                    right--;
                    left++;
                } else if (cur > target) {
                    right--;
                } else {
                    left++;
                }
            }
            res += ways[i];
            res %= mod;
        }
        return res;
    }
}
