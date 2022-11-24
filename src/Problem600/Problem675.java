package Problem600;

import java.util.*;

public class Problem675 {
    public int cutOffTree(List<List<Integer>> forest) {
        int[][] arr = new int[forest.size()][forest.get(0).size()];
        int treeCount = 0;
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int val = forest.get(i).get(j);
                if (val > 1) {
                    treeCount++;
                }
                arr[i][j] = val;
            }
        }
        int[][] targets = new int[treeCount][3];
        for (int i = 0, idx = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 1) {
                    targets[idx++] = new int[]{i, j, arr[i][j]};
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Arrays.sort(targets, Comparator.comparingInt(a -> a[2]));
        int x = 0, y = 0, cost = 0;
        for (int[] target : targets) {
            boolean[][] visited = new boolean[arr.length][arr[0].length];
            ArrayDeque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{x, y});
            boolean found = false;
            visited[x][y] = true;
            int size = 1;
            System.out.println("target: " + Arrays.toString(target) + ", cost: " + cost);
            while (queue.size() > 0) {
                int[] node = queue.removeFirst();
                if (node[0] == target[0] && node[1] == target[1]) {
                    found = true;
                    x = node[0];
                    y = node[1];
                    break;
                }
                for (int[] dir : dirs) {
                    int nx = node[0] + dir[0], ny = node[1] + dir[1];
                    if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length && !visited[nx][ny] && arr[nx][ny] > 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
                if (--size == 0) {
                    size = queue.size();
                    cost++;
                }
            }
            if (!found) {
                return -1;
            }
        }
        return cost;
    }
}
