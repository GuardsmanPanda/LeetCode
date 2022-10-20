package Problem1700;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1772 {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, int[]> map = IntStream.range(0, features.length).boxed().collect(Collectors.toMap(i -> features[i], i -> new int[] {0, i}));
        Arrays.stream(responses)
                .flatMap(s -> Arrays.stream(s.split(" ")).filter(map::containsKey).distinct())
                .forEach(s -> map.get(s)[0]++);
        return map.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue()[0] == e2.getValue()[0] ? e1.getValue()[1] - e2.getValue()[1] : e2.getValue()[0] - e1.getValue()[0])
                .map(Map.Entry::getKey).toArray(String[]::new);
    }
}
