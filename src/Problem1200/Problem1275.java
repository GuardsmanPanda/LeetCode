package Problem1200;

public class Problem1275 {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            board[moves[i][0]][moves[i][1]] = i % 2 == 0 ? 1 : 2;
        }
        int w = getWinner(board);
        return w == 0 ? moves.length == 9 ? "Draw" : "Pending" : w == 1 ? "A" : "B";
    }

    private int getWinner(int[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return 0;
    }
}
