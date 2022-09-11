package Problem1500;

public class Problem1556 {
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n > 0) {
            if (count == 3) {
                sb.append('.');
                count = 0;
            }
            sb.append(n % 10);
            n /= 10;
            count++;
        }
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
