package Problem;

public class Problem37 {
    public void solveSudoku(char[][] board) {
        boolean[] rows = new boolean[81];
        boolean[] cols = new boolean[81];
        boolean[] grids = new boolean[81];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') continue;
                int val = board[i][j]-'1';
                rows[i*9+val] = true;
                cols[j*9+val] = true;
                grids[(i/3*3+j/3)*9+val] = true;
            }
        }
        solveSudoku(0,0, cols, rows, grids, board);
    }
    private boolean solveSudoku(int x, int y, boolean[] col, boolean[] row, boolean[] grid, char[][] board) {
        if (x == 9) return true;
        if (board[x][y] != '.') return solveSudoku(y == 8 ? x+1 : x, (y+1)%9, col, row, grid, board);
        int ir = x*9, ic = y*9, ig = (x/3*3 + y/3)*9;
        for (int i = 0; i < 9; i++) {
            if (row[ir+i] || col[ic+i] || grid[ig+i]) continue;
            row[ir+i] = true; col[ic+i] = true; grid[ig+i] = true;
            board[x][y] = (char)('1'+i);
            if (solveSudoku(y == 8 ? x+1 : x, (y+1)%9, col, row, grid, board))
                return true;
            board[x][y] = '.';
            row[ir+i] = false; col[ic+i] = false; grid[ig+i] = false;
        }
        return false;
    }
}
