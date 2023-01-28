package Problem2500;

public class Problem2515 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int dist = Math.abs(i - startIndex);
                res = Math.min(res, Math.min(dist, words.length - dist));
            }

        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
