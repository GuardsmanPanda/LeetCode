package Problem2400;

public class Problem2423 {
    public boolean equalFrequency(String word) {
        char[] a = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (test(a, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean test(char[] a, int exclude) {
        int[] count = new int[128];
        int min = a.length, max = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != exclude) {
                count[a[i]]++;
            }
        }
        for (int i : count) {
            if (i != 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        return min == max || max == 0;
    }
}
