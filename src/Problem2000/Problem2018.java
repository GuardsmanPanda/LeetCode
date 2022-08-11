package Problem2000;

public class Problem2018 {
    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] w1 = word.toCharArray();
        char[] w2 = new StringBuilder(word).reverse().toString().toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    continue;
                }
                if (i == 0 || board[i - 1][j] == '#') {
                    if (test(board, w1, i, j, 1, 0) || test(board, w2, i, j, 1, 0)) {
                        return true;
                    }
                }
                if (j == 0 || board[i][j - 1] == '#') {
                    if (test(board, w1, i, j, 0, 1) || test(board, w2, i, j, 0, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean test(char[][] board, char[] word, int x, int y, int dx, int dy) {
        if (dx == 1) {
            int end = x + word.length;
            if (end > board.length || (end < board.length && board[end][y] != '#')) {
                return false;
            }
        }
        if (dy == 1) {
            int end = y + word.length;
            if (end > board[0].length || (end < board[0].length && board[x][end] != '#')) {
                return false;
            }
        }
        for (char c : word) {
            if (board[x][y] != c && board[x][y] != ' ') {
                return false;
            }
            x += dx;
            y += dy;
        }
        return true;
    }
}
