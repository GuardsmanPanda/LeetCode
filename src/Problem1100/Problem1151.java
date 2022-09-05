package Problem1100;

public class Problem1151 {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i : data) {
            ones += i;
        }
        int idx = 0, count = 0;
        while (idx < ones) {
            count += 1 - data[idx++];
        }
        int min = count;
        for (int i = 0; idx < data.length; i++, idx++) {
            count += 1 - data[idx];
            count -= 1 - data[i];
            min = Math.min(min, count);
        }
        return min;
    }
}
