package Problem2400;

public class Problem2481 {
    public int numberOfCuts(int n) {
        return n % 2 == 0 ? n / 2 : n == 1 ? 0 : n;
    }
}
