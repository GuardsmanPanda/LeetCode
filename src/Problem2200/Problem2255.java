package Problem2200;

public class Problem2255 {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                res++;
            }
        }
        return res;
    }
}
