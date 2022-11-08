package Problem300;

import java.util.ArrayDeque;

public class Problem353 {
    class SnakeGame {
        private final ArrayDeque<int[]> queue = new ArrayDeque<>();
        private final ArrayDeque<int[]> food = new ArrayDeque<>();
        private final int height;
        private final int width;

        public SnakeGame(int width, int height, int[][] food) {
            for (int[] f : food) {
                this.food.addLast(f);
            }
            queue.addFirst(new int[]{0, 0});
            this.height = height;
            this.width = width;
        }

        public int move(String direction) {
            int[] head = queue.getFirst();
            int[] next = new int[]{
                    head[0] + (direction.equals("U") ? -1 : direction.equals("D") ? 1 : 0),
                    head[1] + (direction.equals("L") ? -1 : direction.equals("R") ? 1 : 0)
            };
            if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width) {
                return -1;
            }
            if (food.size() > 0 && food.getFirst()[0] == next[0] && food.getFirst()[1] == next[1]) {
                food.removeFirst();
            } else {
                queue.removeLast();
            }
            for (int[] qq : queue) {
                if (qq[0] == next[0] && qq[1] == next[1]) {
                    return -1;
                }
            }
            queue.addFirst(next);
            return queue.size() - 1;
        }
    }
}
