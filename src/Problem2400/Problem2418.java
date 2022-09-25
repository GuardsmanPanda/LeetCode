package Problem2400;

import java.util.stream.IntStream;

public class Problem2418 {
    record Person(String name, int height) {}

    public String[] sortPeople(String[] names, int[] heights) {
        return IntStream.range(0, names.length)
            .mapToObj(i -> new Person(names[i], heights[i]))
            .sorted((p1, p2) -> p2.height - p1.height)
            .map(p -> p.name)
            .toArray(String[]::new);
    }
}
