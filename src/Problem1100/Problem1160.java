package Problem1100;

public class Problem1160 {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26];
        for (char c : chars.toCharArray()) {
            charCount[c - 'a']++;
        }
        int ans = 0;
        for (String word : words) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray()) {
                wordCount[c - 'a']++;
            }
            boolean valid = true;
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] > charCount[i]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans += word.length();
            }
        }
        return ans;
    }
}
