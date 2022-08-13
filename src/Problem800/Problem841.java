package Problem800;

import java.util.List;

public class Problem841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        int[] stack = new int[rooms.size()];
        int visited = 1, pointer = 1;
        seen[0] = true;
        while (pointer > 0) {
            int room = stack[--pointer];
            for (Integer adj : rooms.get(room)) {
                if (!seen[adj]) {
                    seen[adj] = true;
                    stack[pointer++] = adj;
                    visited++;
                }
            }
        }
        return visited == rooms.size();
    }
}
