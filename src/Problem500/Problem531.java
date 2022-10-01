package Problem500;

public class Problem531 {
    public int findLonelyPixel(char[][] picture) {
        int[] cols = new int[picture[0].length];
        int[] rows = new int[picture.length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    cols[j]++;
                    rows[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
