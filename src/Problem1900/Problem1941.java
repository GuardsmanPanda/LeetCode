package Problem1900;

public class Problem1941 {
    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int first = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                first = count[i];
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] != first) {
                return false;
            }
        }
        return true;
    }
}
