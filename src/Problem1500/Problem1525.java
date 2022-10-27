package Problem1500;

import java.util.Arrays;

public class Problem1525 {
    public int numSplits(String s) {
        int[] count = new int[26];
        int right = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (count[c - 'a']++ == 0) {
                right++;
            }
        }
        int left = 0, res = 0;
        int[] leftCount = new int[26];
        for (char c : chars) {
            if (--count[c - 'a'] == 0) {
                right--;
            }
            if (leftCount[c - 'a']++ == 0) {
                left++;
            }
            if (left == right) {
                res++;
            }
        }
        return res;
    }
}
