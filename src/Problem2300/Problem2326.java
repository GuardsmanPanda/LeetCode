package Problem2300;

import Types.ListNode;

import java.util.Arrays;

public class Problem2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int[] re : res) {
            Arrays.fill(re, -1);
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, dir = 0;
        while (head != null) {
            res[row][col] = head.val;
            head = head.next;
            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] != -1) {
                dir = (dir + 1) % 4;
            }
            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        return res;
    }
}
