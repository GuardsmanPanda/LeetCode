package Problem1100;

public class Problem1175 {
    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
        return (int) ((factorial(primeCount) * factorial(n-primeCount)) % 1000000007);
    }
    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % 1000000007;
        }
        return result;
    }
}
