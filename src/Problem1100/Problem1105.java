package Problem1100;

public class Problem1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] totalHeight = new int[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            int height = books[i][1];
            int width = books[i][0];
            totalHeight[i + 1] = totalHeight[i] + height;
            for (int j = i - 1; j >= 0 && width + books[j][0] <= shelfWidth; j--) {
                height = Math.max(height, books[j][1]);
                width += books[j][0];
                totalHeight[i + 1] = Math.min(totalHeight[i + 1], totalHeight[j] + height);
            }
        }
        return totalHeight[books.length];
    }
}
