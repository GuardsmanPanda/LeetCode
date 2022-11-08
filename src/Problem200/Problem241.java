package Problem200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem241 {
    private final Map<String, List<Integer>> cache = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (cache.containsKey(expression)) {
            return cache.get(expression);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        result.add(c == '+' ? l + r : c == '-' ? l - r : l * r);
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        cache.put(expression, result);
        return result;
    }
}
