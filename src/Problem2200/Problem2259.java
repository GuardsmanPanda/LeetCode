package Problem2200;

public class Problem2259 {
    public String removeDigit(String number, char digit) {
        StringBuilder sb = new StringBuilder();
        char[] a = number.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != digit) {
                continue;
            }
            for (int k = i; k < a.length - 1 && a[k] == a[i]; k++) {
                if (a[k] < a[k + 1]) {
                    sb.append(a, 0, k);
                    sb.append(a, k + 1, a.length - k - 1);
                    return sb.toString();
                }
            }
        }
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] != digit) {
                sb.append(a[i]);
            } else {
                digit = '!';
            }
        }
        return sb.reverse().toString();
    }
}
