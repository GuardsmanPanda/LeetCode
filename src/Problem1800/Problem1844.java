package Problem1800;

public class Problem1844 {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
            if (i + 1 < s.length()) {
                sb.append((char) (s.charAt(i) + s.charAt(i + 1) - '0'));
            }
        }
        return sb.toString();
    }
}
