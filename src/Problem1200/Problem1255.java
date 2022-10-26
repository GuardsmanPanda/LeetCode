package Problem1200;

public class Problem1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        return getMaxScore(words, 0, count, score, 0);
    }

    private int getMaxScore(String[] words, int idx, int[] count, int[] points, int score) {
        if (idx == words.length) {
            return score;
        }
        int maxScore = getMaxScore(words, idx + 1, count, points, score);
        boolean valid = true;
        int wordScore = 0;
        char[] arr = words[idx].toCharArray();
        for (char c : arr) {
            if (count[c - 'a']-- == 0) {
                valid = false;
            }
            wordScore += points[c - 'a'];
        }
        if (valid) {
            maxScore = Math.max(maxScore, getMaxScore(words, idx + 1, count, points, score + wordScore));
        }
        for (char c : arr) {
            count[c - 'a']++;
        }
        return maxScore;
    }
}
