package Problem2300;

public class Problem2341 {
    public int[] numberOfPairs(int[] nums) {
        boolean[] visited = new boolean[101];
        int[] res = new int[2];
        for (int num : nums) {
            if (visited[num] = !visited[num]) {
                res[1]++;
            } else {
                res[0]++;
                res[1]--;
            }
        }
        return res;
    }
}
