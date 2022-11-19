package Problem700;

public class Problem723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] toCrush = new boolean[m][n];
        boolean crush = false;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n-2; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2]) {
                    toCrush[i][j] = true;
                    toCrush[i][j+1] = true;
                    toCrush[i][j+2] = true;
                    crush = true;
                }
            }
        }
        for (int i=0; i<m-2; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j]) {
                    toCrush[i][j] = true;
                    toCrush[i+1][j] = true;
                    toCrush[i+2][j] = true;
                    crush = true;
                }
            }
        }
        for (int j=0; j<n; j++) {
            int low = m-1, high = m;
            while (high --> 0) {
                if (!toCrush[high][j]) {
                    board[low--][j] = board[high][j];
                }
            }
            while (low >= 0) {
                board[low--][j] = 0;
            }
        }
        return crush ? candyCrush(board) : board;
    }
}
