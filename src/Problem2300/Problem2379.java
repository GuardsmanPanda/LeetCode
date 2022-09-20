package Problem2300;

public class Problem2379 {
    public int minimumRecolors(String blocks, int k) {
        int count = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.length(); i++) {
            if (i >= k && blocks.charAt(i - k) == 'W') {
                count--;
            }
            if (blocks.charAt(i) == 'W') {
                count++;
            }
            if (i >= k - 1) {
                min = Math.min(min, count);
            }
        }
        return min;
    }
}
