package Problem1400;

public class Problem1427 {
    public String stringShift(String s, int[][] shift) {
        int totalShift = 0;
        for (int[] ints : shift) totalShift += ints[0] == 0 ? ints[1] : -ints[1];
        totalShift = (totalShift%s.length() + s.length()) % s.length();
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(totalShift));
            totalShift = (totalShift+1) % s.length();
        }
        return sb.toString();
    }
}
