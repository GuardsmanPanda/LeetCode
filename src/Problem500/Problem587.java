package Problem500;

import java.util.*;

public class Problem587 {
    public int[][] outerTrees(int[][] trees) {
        return findConvexHull(trees);
    }

    private int[][] findConvexHull(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] vector = new int[]{points[0][0] - points[points.length - 1][0], points[0][1] - points[points.length - 1][1]};
        ArrayDeque<int[]> top = new ArrayDeque<>(), bottom = new ArrayDeque<>();
        for (int i = 1; i < points.length - 1; i++) {
            int[] point = points[i];
            int cross = crossProduct(vector, new int[]{points[0][0] - point[0], points[0][1] - point[1]});
            if (cross > 0) {
                top.addFirst(point);
            } else if (cross < 0) {
                bottom.addLast(point);
            } else {
                top.addFirst(point);
                bottom.addLast(point);
            }
        }
        top.addFirst(points[points.length - 1]);
        top.addLast(points[0]);
        bottom.addFirst(points[0]);
        bottom.addLast(points[points.length - 1]);
        Set<int[]> result = new HashSet<>();
        result.addAll(solveHalf(top));
        result.addAll(solveHalf(bottom));
        return result.toArray(new int[0][]);
    }

    private List<int[]> solveHalf(ArrayDeque<int[]> points) {
        List<int[]> result = new ArrayList<>();
        for (int[] p3 : points) {
            while (result.size() > 1) {
                int[] p1 = result.get(result.size() - 2);
                int[] p2 = result.get(result.size() - 1);
                if (crossProduct(new int[]{p2[0] - p1[0], p2[1] - p1[1]}, new int[]{p3[0] - p2[0], p3[1] - p2[1]}) < 0) {
                    result.remove(result.size() - 1);
                } else {
                    break;
                }
            }
            result.add(p3);
        }
        return result;
    }

    private int crossProduct(int[] vector1, int[] vector2) {
        return vector1[0] * vector2[1] - vector1[1] * vector2[0];
    }
}
