package Problem300;

public class Problem370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] tmp = new int[length + 1];
        for (int[] update : updates) {
            tmp[update[0]] += update[2];
            tmp[update[1] + 1] -= update[2];
        }
        int[] result = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += tmp[i];
            result[i] = sum;
        }
        return result;
    }
}
