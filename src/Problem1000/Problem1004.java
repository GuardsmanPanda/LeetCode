package Problem1000;

public class Problem1004 {
    public int longestOnes(int[] a, int k) {
        int longest = 0, left = 0, right = 0;
        while (right < a.length) {
            k -= 1 - a[right++];
            while (k < 0) {
                k += 1 - a[left++];
            }
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}
