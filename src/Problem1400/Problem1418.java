package Problem1400;

import java.util.*;

public class Problem1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> tableFoodCount = new HashMap<>();
        Set<String> tables = new HashSet<>();
        Set<String> foods = new HashSet<>();
        for (List<String> order : orders) {
            String table = order.get(1);
            String food = order.get(2);
            tables.add(table);
            foods.add(food);
            tableFoodCount.compute(table + "-" + food, (k, v) -> v == null ? 1 : v + 1);
        }
        List<String> sortedFoods = new ArrayList<>();
        sortedFoods.add("Table");
        sortedFoods.addAll(foods.stream().sorted().toList());
        List<List<String>> result = new ArrayList<>();
        result.add(sortedFoods);
        tables.stream()
                .sorted(Comparator.comparingInt(Integer::parseInt))
                .map(table -> {
            List<String> row = new ArrayList<>();
            row.add(table);
            for (int i = 1; i < sortedFoods.size(); i++) {
                row.add(String.valueOf(tableFoodCount.getOrDefault(table + "-" + sortedFoods.get(i), 0)));
            }
            return row;
        }).forEach(result::add);
        return result;
    }
}
