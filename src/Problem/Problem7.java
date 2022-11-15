package Problem;

public class Problem7 {
    public int reverse(int x) {
        char[] ca = Integer.toString(x).toCharArray();
        for (int left = 0, right = ca.length - 1; left < right; left++, right--) {
            if (left == 0 && ca[0] == '-') left++;
            char temp = ca[left];
            ca[left] = ca[right];
            ca[right] = temp;
        }
        try {
            return Integer.parseInt(new String(ca));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
