package Problem2400;

public class Problem2485 {
    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2, current = n;
        while (current < total) {
            total -= n;
            current += --n;
        }
        return current == total ? n : -1;
    }
}
