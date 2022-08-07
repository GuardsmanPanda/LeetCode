import java.util.List;
import java.util.stream.IntStream;

public class Problem1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        edges.forEach(e -> visited[e.get(1)] = true);
        return IntStream.range(0, n).filter(i -> !visited[i]).boxed().toList();
    }
}
