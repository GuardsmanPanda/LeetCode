package Problem1000;

public class Problem1047 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (sb.length() == 0 || sb.charAt(sb.length()-1) != c) sb.append(c);
            else sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}
