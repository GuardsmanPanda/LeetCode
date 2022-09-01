package Problem400;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem499 {
    record Position(int x, int y, int dist, StringBuilder path)  implements Comparable<Position> {
        @Override
        public int compareTo(Position o) {
            return dist == o.dist ? path.compareTo(o.path) : dist - o.dist;
        }
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (ball[0] == hole[0] && ball[1] == hole[1]) {
            return "";
        }
        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(ball[0], ball[1], 0, new StringBuilder()));
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dist = new int[maze.length][maze[0].length];
        StringBuilder[][] path = new StringBuilder[maze.length][maze[0].length];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        path[ball[0]][ball[1]] = new StringBuilder();
        dist[ball[0]][ball[1]] = 0;
        while (queue.size() > 0) {
            Position cur = queue.remove();
            System.out.println(cur);
            int x = cur.x, y = cur.y;
            if (x == hole[0] && y == hole[1]) {
                return cur.path.toString();
            }
            for (int[] dir : dirs) {
                int nx = x, ny = y, d = cur.dist;
                while (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze[0].length && maze[nx][ny] == 0) {
                    nx += dir[0];
                    ny += dir[1];
                    d++;
                    if (nx == hole[0] && ny == hole[1]) {
                        nx += dir[0];
                        ny += dir[1];
                        d++;
                        break;
                    }
                }
                nx -= dir[0];
                ny -= dir[1];
                d--;
                if (dist[nx][ny] > d || (dist[nx][ny] == d && path[nx][ny].compareTo(cur.path) > 0)) {
                    System.out.println("nx = " + nx + ", ny = " + ny + ", d = " + d);
                    StringBuilder newPath = new StringBuilder(cur.path);
                    dist[nx][ny] = d;
                    path[nx][ny] = newPath;
                    newPath.append(dir[0] == 0 ? dir[1] == 1 ? 'r' : 'l' : dir[0] == 1 ? 'd' : 'u');
                    queue.add(new Position(nx, ny, d, newPath));
                }
            }
        }
        return "impossible";
    }
}
