package Problem;

import java.util.stream.IntStream;

public class Problem9 {
    public boolean isPalindrome(int x) {
        char[] ca = Integer.toString(x).toCharArray();
        return IntStream.range(0, ca.length / 2).allMatch(i -> ca[i] == ca[ca.length - i - 1]);
    }
}
