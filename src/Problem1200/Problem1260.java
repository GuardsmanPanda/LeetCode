package Problem1200;

import java.util.ArrayList;
import java.util.List;

public class Problem1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int total = grid.length * grid[0].length;
        k %= total;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                int pos = (i * grid[0].length + j - k + total) % total;
                tmp.add(grid[pos / grid[0].length][pos % grid[0].length]);
            }
            res.add(tmp);
        }
        return res;
    }
}
