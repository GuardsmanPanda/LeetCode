package Problem1200;


import java.util.ArrayList;
import java.util.List;

public class Problem1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] i : intervals) {
            if (i[1] <= toBeRemoved[0] || i[0] >= toBeRemoved[1]) {
                result.add(List.of(i[0], i[1]));
            } else {
                if (i[0] < toBeRemoved[0]) result.add(List.of(i[0], toBeRemoved[0]));
                if (i[1] > toBeRemoved[1]) result.add(List.of(toBeRemoved[1], i[1]));
            }
        }
        return result;
    }
}
