package Problem2000;

public class Problem2007 {
    public int[] findOriginalArray(int[] changed) {
        int[] counter = new int[100001];
        for (int i : changed) {
            counter[i]++;
        }
        int[] result = new int[changed.length / 2];
        int index = 0;
        for (int i = 0; i < counter.length/2; i++) {
            while (counter[i] > 0) {
                counter[i]--;
                if (--counter[i * 2] < 0) {
                    return new int[0];
                }
                result[index++] = i;
            }
        }
        return index == result.length ? result : new int[0];
    }
}
