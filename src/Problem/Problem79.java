package Problem;

public class Problem79 {
    public boolean exist(char[][] board, String word) {
        char[] ca = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ca[0]) {
                    if (searchForWord(i, j, board, ca, 0)) return true;
                }
            }
        }
        return false;
    }
    private final int[] yDir = {-1,0,1,0};
    private final int[] xDir = {0,1,0,-1};
    private boolean searchForWord(int y, int x, char[][] board, char[] word, int index) {
        if (index == word.length -1) return true;
        for (int i = 0; i < xDir.length; i++) {
            int dY = y + yDir[i];
            int dX = x + xDir[i];
            if (dY >= 0 && dX >= 0 && dY < board.length && dX < board[0].length) {
                if (board[dY][dX] == word[index+1]) {
                    char temp = board[y][x];
                    board[y][x] = '#';
                    if (searchForWord(dY, dX, board, word, index+1)) {
                        board[y][x] = temp;
                        return true;
                    }
                    board[y][x] = temp;
                }
            }
        }
        return false;
    }
}
