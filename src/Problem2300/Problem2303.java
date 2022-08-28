package Problem2300;

public class Problem2303 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int taxed = 0;
        for (int[] bracket : brackets) {
            int val = Math.min(income - taxed, bracket[0] - taxed);
            res += val / 100.0 * bracket[1];
            taxed += val;
        }
        return res;
    }
}
