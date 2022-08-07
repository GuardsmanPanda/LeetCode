import java.util.Arrays;

public class Problem1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        int[] sum = new int[n];
        for (int[] road : roads) {
            graph[road[0]][road[1]] = 1;
            graph[road[1]][road[0]] = 1;
            sum[road[0]]++;
            sum[road[1]]++;
        }
        System.out.println(Arrays.toString(sum));
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max = Math.max(max, sum[i] + sum[j] - (graph[i][j] == 1 ? 1 : 0));
            }
        }
        return max;
    }
}
