package Problem;

public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] columns = new boolean[9][9];
        boolean[][] subGrids = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            boolean[] row = new boolean[9];
            for (int j = 0; j < board.length; j++) {
                int number = board[i][j] - '1';
                if (number < 0) continue;
                if (row[number]) return false;
                else row[number] = true;

                if (columns[j][number]) return false;
                else columns[j][number] = true;

                int subgrid = j/3 + (i/3)*3;
                if (subGrids[subgrid][number]) return false;
                else subGrids[subgrid][number] = true;
            }
        }
        return true;
    }
}
