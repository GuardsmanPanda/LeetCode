package Problem2100;

public class Problem2113 {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int time = queries[i][0], index = queries[i][1];
            time %= nums.length * 2;
            if (time < nums.length) {
                index += time;
                res[i] = index < nums.length ? nums[index] : -1;
            } else {
                res[i] = -2;
            }
        }
        return res;
    }
}
