package Problem2000;

public class Problem2038 {
    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0;
        for (int i = 0; i < colors.length() - 2; i++) {
            char c = colors.charAt(i);
            if (c == colors.charAt(i + 1) && c == colors.charAt(i + 2)) {
                a += 1 - (c - 'A');
                b += c - 'A';
            }
        }
        return a > b;
    }
}
