package Problem1900;

public class Problem1945 {
    public int getLucky(String s, int k) {
        int sum = s.chars().map(c -> c - 'a' + 1).map(c -> c / 10 + c % 10).sum();
        for (int i = 1; i < k; i++) {
            int tmp = 0;
            while (sum > 0) {
                tmp += sum % 10;
                sum /= 10;
            }
            sum = tmp;
        }
        return sum;
    }
}
