package Problem1400;

public class Problem1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] c1 = new char[26], c2 = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
            c2[s2.charAt(i) - 'a']++;
        }
        boolean positive = true;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += c1[i];
            count -= c2[i];
            if (count < 0) {
                positive = false;
            }
        }
        if (positive) {
            return true;
        }
        for (int i = 0; i < 26; i++) {
            count += c1[i];
            count -= c2[i];
            if (count > 0) {
                return false;
            }
        }
        return true;
    }
}
