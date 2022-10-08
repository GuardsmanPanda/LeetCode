package Problem1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1087 {
    public String[] expand(String s) {
        String[] a = genStrings(s.toCharArray(), 0, new ArrayList<>(), new StringBuilder()).toArray(new String[0]);
        Arrays.sort(a);
        return a;
    }

    private List<String> genStrings(char[] a, int idx, List<String> res, StringBuilder sb) {
        if (idx == a.length) {
            res.add(sb.toString());
            return res;
        }
        if (a[idx] == '{') {
            int end = idx + 1;
            while (a[end] != '}') {
                end++;
            }
            while (++idx != end) {
                if (a[idx] != ',') {
                    sb.append(a[idx]);
                    genStrings(a, end + 1, res, sb);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        } else {
            sb.append(a[idx]);
            genStrings(a, idx + 1, res, sb);
            sb.setLength(sb.length() - 1);
        }
        return res;
    }
}
