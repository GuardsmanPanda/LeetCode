package Problem200;

public class Problem246 {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            char a = num.charAt(i);
            char b = num.charAt(j);
            if (a == '0' && b == '0' || a == '1' && b == '1' || a == '8' && b == '8' || a == '6' && b == '9' || a == '9' && b == '6') {
                continue;
            }
            return false;
        }
        return true;
    }
}
