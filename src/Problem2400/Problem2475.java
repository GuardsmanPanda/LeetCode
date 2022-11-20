package Problem2400;

public class Problem2475 {
    public int unequalTriplets(int[] nums) {
        int[] data = new int[1001];
        for (int n : nums) {
            data[n]++;
        }
        int triples = 0, doubles = 0, singles = 0;
        for (int n : data) {
            if (n > 0) {
                triples += doubles * n;
                doubles += singles * n;
                singles += n;
            }
        }
        return triples;
    }
}
