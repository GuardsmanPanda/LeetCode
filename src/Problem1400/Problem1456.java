package Problem1400;

public class Problem1456 {
    public int maxVowels(String s, int k) {
        int max = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cur++;
            }
            if (i >= k && ((c = s.charAt(i - k)) == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                cur--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
