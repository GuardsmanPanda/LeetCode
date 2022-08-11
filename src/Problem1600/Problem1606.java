package Problem1600;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1606 {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] count = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];
            while (!busy.isEmpty() && busy.peek()[1] <= time) {
                available.add(busy.remove()[0]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer server = available.ceiling(i % k);
            if (server == null) {
                server = available.first();
            }
            count[server]++;
            busy.add(new int[]{server, time + load[i]});
            available.remove(server);
        }
        int max = Arrays.stream(count).max().orElse(-1);
        return IntStream.range(0, k).filter(i -> count[i] == max).boxed().collect(Collectors.toList());
    }
}
