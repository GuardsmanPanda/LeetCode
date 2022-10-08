package Problem2100;

public class Problem2113 {
    public int[] elementInNums(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int[] query : queries) {
            int idx = query[0], time = query[1];
            time %= nums.length * 2;
        }
        return res;
    }
}
