package Problem;

public class Problem72 {
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] distance = new int[w1.length + 1][w2.length + 1];
        for (int i = 0; i <= w1.length; i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= w2.length; i++) {
            distance[0][i] = i;
        }
        for (int i = 1; i <= w1.length; i++) {
            for (int j = 1; j <= w2.length; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(distance[i - 1][j], Math.min(distance[i][j - 1], distance[i - 1][j - 1])) + 1;
                }
            }
        }
        return distance[w1.length][w2.length];
    }
}
