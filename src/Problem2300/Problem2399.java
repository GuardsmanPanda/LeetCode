package Problem2300;

import java.util.Arrays;

public class Problem2399 {
    public boolean checkDistances(String s, int[] distance) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (last[index] != -1 && i - last[index] - 1 != distance[index]) {
                return false;
            }
            last[index] = i;
        }
        return true;
    }
}
