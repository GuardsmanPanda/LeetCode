package Problem400;

import Types.Robot;

import java.util.ArrayDeque;

public class Problem489 {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        boolean[][] visited = new boolean[405][405];
        dfs(robot, 201, 201, 3, visited);
    }

    private void dfs(Robot robot, int x, int y, int dir, boolean[][] visited) {
        robot.clean();
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (!visited[nx][ny]) {
                if (robot.move()) {
                    dfs(robot, nx, ny, dir, visited);
                    robot.turnLeft();
                    robot.turnLeft();
                    robot.move();
                    robot.turnLeft();
                } else {
                    visited[nx][ny] = true;
                    robot.turnRight();
                }
            } else {
                robot.turnRight();
            }
            dir = ++dir % 4;
        }
    }
}
