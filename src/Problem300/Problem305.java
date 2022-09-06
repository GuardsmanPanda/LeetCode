package Problem300;

import java.util.ArrayList;
import java.util.List;

public class Problem305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] matrix = new int[m][n];
        int[] parent = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<Integer> result = new ArrayList<>();
        int islandCount = 0;
        for (int[] p : positions) {
            islandCount += 1 - matrix[p[0]][p[1]];
            matrix[p[0]][p[1]] = 1;
            for (int[] d : directions) {
                int x = p[0] + d[0];
                int y = p[1] + d[1];
                if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 1) {
                    int root1 = findRoot(parent, p[0] * n + p[1]);
                    int root2 = findRoot(parent, x * n + y);
                    if (root1 != root2) {
                        parent[root1] = root2;
                        islandCount--;
                    }
                }
            }
            result.add(islandCount);
        }
        return result;
    }

    private int findRoot(int[] parent, int index) {
        return parent[index] == index ? index : (parent[index] = findRoot(parent, parent[index]));
    }
}
