import java.util.Arrays;

public class Problem1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 0, high = position[position.length-1]-position[0];
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (check(position, mid, m)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public boolean check(int[] arr, int target, int amount) {
        int count = 1, lastIdx = 0;
        //System.out.println("target: " + target);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[lastIdx] >= target) {
                //System.out.println("arr[i]: " + arr[i] + " arr[lastIdx]: " + arr[lastIdx]);
                count++;
                lastIdx = i;
            }
        }
        return count >= amount;
    }
}
