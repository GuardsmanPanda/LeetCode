package Problem1500;

import java.util.Arrays;

public class Problem1591 {
    public boolean isPrintable(int[][] targetGrid) {
        boolean fixed = true;
        int count = targetGrid.length * targetGrid[0].length;
        while (fixed) {
            fixed = false;
            int[][] pos = new int[61][];
            for (int i = 0; i < targetGrid.length; i++) {
                for (int j = 0; j < targetGrid[0].length; j++) {
                    int c = targetGrid[i][j];
                    if (pos[c] == null) {
                        pos[c] = new int[]{i, i, j, j};
                    } else {
                        pos[c][0] = Math.min(pos[c][0], i);
                        pos[c][1] = Math.max(pos[c][1], i);
                        pos[c][2] = Math.min(pos[c][2], j);
                        pos[c][3] = Math.max(pos[c][3], j);
                    }
                }
            }
            for (int i = 1; i < pos.length; i++) {
                if (pos[i] == null) {
                    continue;
                }
                int[] p = pos[i];
                boolean canPrint = true;
                for (int j = p[0]; j <= p[1]; j++) {
                    for (int k = p[2]; k <= p[3]; k++) {
                        if (targetGrid[j][k] != i && targetGrid[j][k] != 0) {
                            canPrint = false;
                            break;
                        }
                    }
                }
                if (canPrint) {
                    fixed = true;
                    for (int j = p[0]; j <= p[1]; j++) {
                        for (int k = p[2]; k <= p[3]; k++) {
                            count -= targetGrid[j][k] == i ? 1 : 0;
                            targetGrid[j][k] = 0;
                        }
                    }
                }
            }
        }
        return count == 0;
    }
}
