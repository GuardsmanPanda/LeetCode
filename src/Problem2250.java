import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2250 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> rectanglesList = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            rectanglesList.add(new ArrayList<>());
        }
        for (int[] rectangle : rectangles) {
            rectanglesList.get(rectangle[1]).add(rectangle[0]);
        }
        int[][] arr = new int[rectanglesList.size()][];
        for (int i = 0; i < rectanglesList.size(); i++) {
            arr[i] = rectanglesList.get(i).stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(arr[i]);
        }
        int[] res = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int sum = 0;
            for (int k = p[1]; k <= 100; k++) {
                int[] a = arr[k];
                int left = 0, right = a.length;
                while (left < right) {
                    int mid = (right - left) / 2 + left;
                    if (a[mid] < p[0]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                sum += a.length - right;
            }
            res[i] = sum;
        }
        return res;
    }
}
