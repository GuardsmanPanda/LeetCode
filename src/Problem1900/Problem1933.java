package Problem1900;

public class Problem1933 {
    public boolean isDecomposable(String s) {
        char[] arr = s.toCharArray();
        boolean found2 = false;
        for (int i = 0; i < arr.length;) {
            int len = 1;
            while (i + len < arr.length && arr[i + len] == arr[i]) {
                len++;
            }
            int rem = len % 3;
            if (rem == 1 || rem == 2 && found2) {
                return false;
            }
            if (rem == 2) {
                found2 = true;
            }
            i += len;
        }
        return found2;
    }
}
