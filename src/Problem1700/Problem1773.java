package Problem1700;

import java.util.List;

public class Problem1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = switch (ruleKey) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> -1;
        };
        return (int) items.stream().filter(item -> item.get(index).equals(ruleValue)).count();
    }
}
