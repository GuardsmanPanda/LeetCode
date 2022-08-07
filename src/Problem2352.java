import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2352 {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> found = Arrays.stream(grid).map(row -> {
                    return IntStream.range(0, grid[0].length)
                            .mapToObj(c -> String.valueOf(row[c]))
                            .collect(Collectors.joining(","));
                })
                .collect(Collectors.toMap(s -> s, s -> 1, Integer::sum));

        return IntStream.range(0, grid.length)
                .mapToObj(c -> {
                    return IntStream.range(0, grid[0].length)
                            .mapToObj(r -> String.valueOf(grid[r][c]))
                            .collect(Collectors.joining(","));
                })
                .mapToInt(s -> found.getOrDefault(s, 0))
                .sum();
    }
}
