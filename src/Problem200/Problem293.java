package Problem200;

import java.util.ArrayList;
import java.util.List;

public class Problem293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> res = new ArrayList<>();
        char[] chars = currentState.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '+' && chars[i - 1] == '+') {
                chars[i] = '-';
                chars[i - 1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i - 1] = '+';
            }
        }
        return res;
    }
}
