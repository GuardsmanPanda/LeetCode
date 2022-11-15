package Problem2100;

public class Problem2120 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int x = startPos[0], y = startPos[1], length = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'U') {
                    x--;
                } else if (s.charAt(j) == 'D') {
                    x++;
                } else if (s.charAt(j) == 'L') {
                    y--;
                } else {
                    y++;
                }
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
                length++;
            }
            res[i] = length;
        }
        return res;
    }
}
