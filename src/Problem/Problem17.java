package Problem;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        List<String> output = new ArrayList<>(digits.length() * 4);
        generateOutput(digits, 0, new StringBuilder(), output);
        return output;
    }

    char[][] keyMapping = {{' '}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    private void generateOutput(String digits, int index, StringBuilder builder, List<String> output) {
        if (index == digits.length()) {
            output.add(builder.toString());
            return;
        }
        for (char c : keyMapping[digits.charAt(index) - '0']) {
            builder.append(c);
            generateOutput(digits, index + 1, builder, output);
            builder.setLength(builder.length() - 1);
        }
    }
}
