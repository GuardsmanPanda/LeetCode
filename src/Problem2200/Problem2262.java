package Problem2200;

import java.util.Arrays;

// abbca
//1-> 1, 1, 1, 1, 1
//2-> -, 2, 1, 2, 2
//3-> -, -, 2, 2, 3
//4-> -, -, -, 3, 3
//5-> -, -, -, -, 3
// -> 1, 3, 4, 8, 12
// -> 1, 3, 6, 10, 15

// tet
//1-> 1, 1, 1,
//2-> -, 2, 2,
//3-> -, -, 2,

public class Problem2262 {
    public long appealSum(String s) {
        int[] pos = new int[128];
        Arrays.fill(pos, -1);
        long subCount = 0;
        long total = 0;
        for (int i = 0; i < s.length(); i++) {
            subCount += i + 1;
            int c = s.charAt(i);
            if (pos[c] != -1) {
                subCount -= pos[c] + 1;
            }
            pos[c] = i;
            total += subCount;
        }
        return total;
    }
}
