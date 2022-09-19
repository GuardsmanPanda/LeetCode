package Problem1200;

public class Problem1228 {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return arr[i - 1] + diff;
            }
        }
        return arr[0];
    }
}
