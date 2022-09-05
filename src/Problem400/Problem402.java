package Problem400;

import java.util.ArrayDeque;

public class Problem402 {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        if (k < 1) return num;
        int from = 0, deletedFrom = 0, deleted = 0, index = 0;
        while (index < num.length() && deleted <= k) {
            if (num.charAt(index++) == '0') {
                while (index < num.length() && num.charAt(index) == '0')
                    index++;
                from = index;
                deletedFrom = deleted;
            } else deleted++;
        }
        if (from + k - deletedFrom >= num.length()) return "0";
        return removeDigits(num.substring(from), k-deletedFrom);
    }

    private String removeDigits(String numbers, int count) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int index = 0;
        while (index < numbers.length() && count > 0) {
            char c = numbers.charAt(index++);
            while (!stack.isEmpty() && count > 0 &&c < stack.peekFirst()) {
                stack.removeFirst();
                count--;
            }
            stack.addFirst(c);
        }
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) output.append(stack.removeLast());
        if (count > 0) {
            output.setLength(output.length()-count);
            return output.toString();
        }
        else return output + numbers.substring(index);
    }
}
