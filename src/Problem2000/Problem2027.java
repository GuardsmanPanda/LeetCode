package Problem2000;

public class Problem2027 {
    public int minimumMoves(String s) {
        int moves = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                moves++;
                i += 2;
            }
        }
        return moves;
    }
}
