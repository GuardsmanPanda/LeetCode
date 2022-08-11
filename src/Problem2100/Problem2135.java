package Problem2100;

import java.util.Arrays;
import java.util.HashSet;

public class Problem2135 {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> startSorted = new HashSet<>();
        for (String startWord : startWords) {
            char[] chars = startWord.toCharArray();
            Arrays.sort(chars);
            startSorted.add(new String(chars));
        }
        int res = 0;
        for (String targetWord : targetWords) {
            char[] chars = targetWord.toCharArray();
            Arrays.sort(chars);
            char[] target = new char[chars.length - 1];
            System.arraycopy(chars, 1, target, 0, chars.length - 1);
            if (startSorted.contains(new String(target))) {
                res++;
                continue;
            }
            char tmp = chars[0];
            for (int i = 0; i < target.length; i++) {
                char c = target[i];
                target[i] = tmp;
                tmp = c;
                if (startSorted.contains(new String(target))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
