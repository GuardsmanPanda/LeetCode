package Problem2300;

public class Problem2390 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.setLength(Math.max(0, sb.length() - 1));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
