package Problem1300;

public class Problem1358 {
    public int numberOfSubstrings(String s) {
        int left = 0, right = -1, result = 0, diff = 3;
        int[] count = new int[3];
        while (++right < s.length()) {
            if (count[s.charAt(right) - 'a']++ == 0) {
                diff--;
            }
            while (count[s.charAt(left) - 'a'] > 1) {
                count[s.charAt(left++) - 'a']--;
            }
            if (diff == 0) {
                result += left + 1;
            }
        }
        return result;
    }
}
