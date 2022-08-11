package Problem;

public class Problem76 {
    public String minWindow(String s, String t) {
        int[] charCount = new int[128];
        int diff = 0;
        for (char c : t.toCharArray()) {
            if (charCount[c] == 0) diff++;
            charCount[c]++;
        }
        int minLength = Integer.MAX_VALUE;
        int leftMin = -1;
        int left = 0, right = 0;
        while (right < s.length()) {
            while (right < s.length() && diff > 0) {
                char c = s.charAt(right);
                right++;
                charCount[c]--;
                if (charCount[c] == 0) diff--;
            }
            while (diff == 0) {
                if (right-left < minLength) {
                    minLength = right-left;
                    leftMin = left;
                }
                char c = s.charAt(left);
                if (charCount[c] == 0) diff++;
                charCount[c]++;
                left++;
            }
        }
        return leftMin != -1 ? s.substring(leftMin, leftMin+minLength) : "";
    }
}
