package Problem800;

public class Problem899 {
    public String orderlyQueue(String S, int K) {
        char[] arr = S.toCharArray();
        int len = S.length();
        if (K > 1) {
            int[] count = new int[128];
            for (char c : arr) count[c]++;
            StringBuilder sb = new StringBuilder(len);
            for (int i = 'a'; i <= 'z'; i++) {
                while (count[i]-- > 0) sb.appendCodePoint(i);
            }
            return sb.toString();
        }
        int rot = 0;
        for (int i = 1; i < len; i++) {
            boolean better = false;
            for (int m = 0; m < len; m++) {
                int a = (rot+m) % len, b = (i+m) % len;
                if (arr[a] < arr[b]) {
                    break;
                }
                if (arr[b] < arr[a]) {
                    better = true;
                    break;
                }
            }
            if (better) rot = i;
        }
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) sb.append(arr[(rot+i)%len]);
        return sb.toString();
    }
}
