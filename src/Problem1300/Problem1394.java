package Problem1300;

public class Problem1394 {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (count[i] == i) return i;
        }
        return -1;
    }
}
