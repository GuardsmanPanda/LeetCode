package Problem1600;

import java.util.HashSet;
import java.util.Set;

public class Problem1647 {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Set<Integer> taken = new HashSet<>();
        int ans = 0;
        for (int x : count) {
            while (x != 0 && !taken.add(x)) {
                ans++;
                x--;
            }
        }
        return ans;
    }
}
