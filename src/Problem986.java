import java.util.ArrayList;
import java.util.List;

public class Problem986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersection = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while (idx1 < firstList.length && idx2 < secondList.length) {
            int[] first = firstList[idx1];
            int[] second = secondList[idx2];
            int start = Math.max(first[0], second[0]);
            int end = Math.min(first[1], second[1]);
            if (start <= end) {
                intersection.add(new int[] {start, end});
            }
            if (first[1] < second[1]) {
                idx1++;
            } else {
                idx2++;
            }
        }
        return intersection.toArray(new int[0][]);
    }
}
