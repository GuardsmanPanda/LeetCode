package Problem500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Integer> idToIdx = new HashMap<>(pid.size());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < pid.size(); i++) {
            graph.add(new ArrayList<>());
            idToIdx.put(pid.get(i), i);
        }
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            if (parent != 0) {
                graph.get(idToIdx.get(parent)).add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(idToIdx.get(kill));
        int cur = 0;
        while (cur < result.size()) {
            int node = result.get(cur);
            result.addAll(graph.get(node));
            result.set(cur++, pid.get(node));
        }
        return result;
    }
}
