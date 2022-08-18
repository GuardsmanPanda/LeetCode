package Problem2300;

import java.util.Arrays;

public class Problem2325 {
    public String decodeMessage(String key, String message) {
        int[] keyArr = new int[128];
        Arrays.fill(keyArr, -1);
        int found = 0;
        for (int i = 0; i < key.length() && found < 26; i++) {
            char c = key.charAt(i);
            if (c != ' ' && keyArr[c] == -1) {
                keyArr[c] = found++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                sb.append(' ');
            } else {
                sb.append((char)('a' + keyArr[c]));
            }
        }
        return sb.toString();
    }
}
