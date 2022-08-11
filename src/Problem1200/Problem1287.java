package Problem1200;

public class Problem1287 {
    public int findSpecialInteger(int[] arr) {
        int left = 0, right = arr.length - 1;
        int minLength = (arr.length + 4) / 4;
        while (left < right) {
            if (right - left + 1 < minLength * 2) {
                return arr[(right - left) / 2 + left];
            }
            int test = left + minLength - 1;
            int tl = test, tr = right;
            while (tl < tr) {
                int tm = tl + (tr - tl + 1) / 2;
                if (arr[tm] == arr[test]) {
                    tl = tm;
                } else {
                    tr = tm - 1;
                }
            }
            if (tl >= test && arr[tl - minLength + 1] == arr[test]) {
                return arr[test];
            }
            left = tl + 1;
        }
        return arr[left];
    }
}
