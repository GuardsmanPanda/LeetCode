package Problem1400;

public class Problem1442 {
    public int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                cur ^= arr[j];
                if (cur == 0) {
                    res += j - i;
                }
            }
        }
        return res;
    }
}
