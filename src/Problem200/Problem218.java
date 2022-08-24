package Problem200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> active = new PriorityQueue<>(Comparator.comparingInt((int[] arr) -> arr[2]).reversed());
        List<List<Integer>> output = new ArrayList<>();
        int index = 0, lastHeight = 0;
        while(index < buildings.length || active.size() > 0) {
            int activePos = active.isEmpty() ? Integer.MAX_VALUE : active.peek()[1];
            int position = index == buildings.length ? activePos : Math.min(buildings[index][0], activePos);
            while (index < buildings.length && buildings[index][0] == position) {
                active.add(buildings[index]);
                index++;
            }
            while (!active.isEmpty() && active.peek()[1] <= position) active.remove();
            int newHeight = active.isEmpty() ? 0 : active.peek()[2];
            if (newHeight != lastHeight) {
                output.add(List.of(position, newHeight));
                lastHeight = newHeight;
            }
        }
        return output;
    }
}
