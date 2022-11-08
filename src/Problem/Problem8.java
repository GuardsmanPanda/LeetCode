package Problem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem8 {
    public int myAtoi(String str) {
        Matcher matcher = Pattern.compile("^\\s*([+-]?)0*(\\d*)").matcher(str);
        if (matcher.find()) {
            try {
                String sign = matcher.group(1);
                String r = matcher.group(2);
                if (r.isEmpty()) {
                    return 0;
                }
                if (r.length() > 11) {
                    return sign.equals("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                return (int)Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, Long.parseLong(sign+r)));
            } catch (NumberFormatException e) {
                return Integer.MIN_VALUE;
            }
        }
        return Integer.MIN_VALUE;
    }
}
