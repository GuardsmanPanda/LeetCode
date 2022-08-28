package Problem2300;

import java.util.Arrays;

public class Problem2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        int[] lastIdx = new int[128];
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                lastIdx[c] = i;
            }
            ans += garbage[i].length();
        }
        for (int i = 0; i < travel.length; i++) {
            if (lastIdx['G'] > i) {
                ans += travel[i];
            }
            if (lastIdx['P'] > i) {
                ans += travel[i];
            }
            if (lastIdx['M'] > i) {
                ans += travel[i];
            }
        }
        return ans;
    }
}
