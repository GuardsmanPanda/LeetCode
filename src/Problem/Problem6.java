package Problem;

public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder output = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i += (numRows - 1) * 2) {
            output.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1 && i < s.length(); i++) {
            for (int k = i; k < s.length(); k += (numRows - 1) * 2) {
                output.append(s.charAt(k));
                int nextPos = k + (numRows - 1 - i) * 2;
                if (nextPos < s.length()) {
                    output.append(s.charAt(nextPos));
                }
            }
        }
        for (int i = numRows - 1; i < s.length(); i += (numRows - 1) * 2) {
            output.append(s.charAt(i));
        }
        return output.toString();
    }
}
