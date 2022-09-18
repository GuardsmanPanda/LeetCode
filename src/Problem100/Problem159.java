package Problem100;

public class Problem159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] count = new int[128];
        int diff = 0, max = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) diff++;
            while (diff > 2) {
                if (--count[s.charAt(left++)] == 0) diff--;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
