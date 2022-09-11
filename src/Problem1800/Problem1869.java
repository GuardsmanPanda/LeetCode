package Problem1800;

public class Problem1869 {
    public boolean checkZeroOnes(String s) {
        int maxZero = 0, maxOne = 0, zero = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                maxZero = Math.max(maxZero, ++zero);
                one = 0;
            } else {
                maxOne = Math.max(maxOne, ++one);
                zero = 0;
            }
        }
        return maxOne > maxZero;
    }
}
