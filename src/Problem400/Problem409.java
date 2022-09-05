package Problem400;

public class Problem409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) count[c]++;

        int length = 0;
        boolean foundOdd = false;
        for (int i = 'A'; i <= 'z'; i++) {
            if (!foundOdd && count[i] % 2 == 1) foundOdd = true;
            length += (count[i]/2)*2;
        }
        return foundOdd ? length+1 : length;
    }
}
