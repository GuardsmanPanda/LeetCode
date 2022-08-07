public class Problem2147 {
    public int numberOfWays(String corridor) {
        long mod = 1_000_000_007L;
        long ways = 1;
        int neededSeats = 2;
        int idx = 0;
        while (idx < corridor.length()) {
            while (idx < corridor.length() && neededSeats > 0) {
                if (corridor.charAt(idx++) == 'S') {
                    neededSeats--;
                }
            }
            long plants = 0;
            while (idx < corridor.length() && corridor.charAt(idx) == 'P') {
                plants++;
                idx++;
            }
            System.out.println("idx: " + idx + " plants: " + plants);
            if (idx != corridor.length()) {
                ways = (ways * (plants + 1)) % mod;
                neededSeats = 2;
            }
        }
        return neededSeats == 2 ? (int) ways : 0;
    }
}
