package Problem1300;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1324 {
    public List<String> printVertically(String s) {
        ArrayDeque<String> queue = new ArrayDeque<>(Arrays.asList(s.split(" ")));
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        boolean added = true;
        int idx = 0;
        while (added) {
            added = false;
            int ids = 0, len = 0;
            for (int i = queue.size(); i > 0; i--) {
                String str = queue.removeFirst();
                if (idx < str.length()) {
                    arr[ids++] = str.charAt(idx);
                    len = ids;
                } else {
                    arr[ids++] = ' ';
                }
                queue.addLast(str);
            }
            if (len > 0) {
                res.add(new String(arr, 0, len));
                added = true;
                idx++;
            }
        }
        return res;
    }
}
