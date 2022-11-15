package Problem;

import java.util.Arrays;

public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        char[] prefix = strs[0].toCharArray();
        int index = prefix.length;
        for (int i = 1; i < strs.length; i++) {
            index = Math.min(index, strs[i].length());
            for (int p = 0; p < index; p++) {
                if (prefix[p] != strs[i].charAt(p)) {
                    index = p;
                    break;
                }
            }
        }
        return new String(Arrays.copyOf(prefix, index));
    }
}
