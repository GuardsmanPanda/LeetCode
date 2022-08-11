package Problem2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2184 {
    public int buildWall(int height, int width, int[] bricks) {
        List<Integer> rows = new ArrayList<>();
        genRows(0, width, bricks, 0, rows);
        if (height == 1) {
            return rows.size();
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            graph.add(new ArrayList<>());
            int ri = rows.get(i);
            for (int j = 0; j < rows.size(); j++) {
                int rj = rows.get(j);
                if ((ri & rj) == 0) {
                    graph.get(i).add(j);
                }
            }
        }
        int[][] ways = new int[height][rows.size()];
        Arrays.fill(ways[0], 1);
        for (int i = 0; i < height - 1; i++) {
            for (int k = 0; k < rows.size(); k++) {
                for (Integer adj : graph.get(k)) {
                    ways[i + 1][adj] += ways[i][k];
                    ways[i + 1][adj] %= 1000000007;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < rows.size(); i++) {
            sum += ways[height - 1][i];
            sum %= 1000000007;
        }
        return sum;
    }

    private void genRows(int index, int width, int[] bricks, int state, List<Integer> rows) {
        if (index >= width) {
            if (index == width) {
                rows.add(state);
            }
            return;
        }
        if (index != 0) {
            state |= 1 << (index - 1);
        }
        for (int brick : bricks) {
            genRows(index + brick, width, bricks, state, rows);
        }
    }
}
