package Problem1900;

import java.util.ArrayList;
import java.util.List;

public class Problem1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (i != 0 && land[i - 1][j] == 1 || j != 0 && land[i][j - 1] == 1 || land[i][j] == 0) {
                    continue;
                }
                int x = i, y = j;
                while (x < land.length && land[x][j] == 1) {
                    x++;
                }
                while (y < land[0].length && land[i][y] == 1) {
                    y++;
                }
                res.add(new int[]{i, j, x - 1, y - 1});
            }
        }
        return res.toArray(new int[0][]);
    }
}
