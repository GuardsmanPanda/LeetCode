package Problem400;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem451 {
    public String frequencySort(String s) {
        StringBuilder returnBuilder = new StringBuilder();
        s.codePoints().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<Integer, Long>::getValue).reversed())
                .forEachOrdered(entry -> {
                    for (int i = 0; i < entry.getValue(); i++) {
                        returnBuilder.appendCodePoint(entry.getKey());
                    }
                });
        return returnBuilder.toString();
    }
}
