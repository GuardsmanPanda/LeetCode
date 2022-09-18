package Problem1400;

import java.util.ArrayDeque;

public class Problem1417 {
    public String reformat(String s) {
        ArrayDeque<Character> letters = new ArrayDeque<>();
        ArrayDeque<Character> digits = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
            else {
                digits.add(c);
            }
        }
        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean useLetters = letters.size() > digits.size();
        while (!letters.isEmpty() || !digits.isEmpty()) {
            if (useLetters) {
                sb.append(letters.poll());
            }
            else {
                sb.append(digits.poll());
            }
            useLetters = !useLetters;
        }
        return sb.toString();
    }
}
