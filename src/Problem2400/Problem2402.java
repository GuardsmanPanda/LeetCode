package Problem2400;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<long[]> roomPool = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }
        int[] roomCount = new int[n];
        long clock = 0;
        for (int[] meeting : meetings) {
            clock = Math.max(clock, meeting[0]);
            while (!roomPool.isEmpty() && roomPool.peek()[0] <= clock) {
                availableRooms.add((int) roomPool.poll()[1]);
            }
            if (availableRooms.isEmpty()) {
                clock = Math.max(clock, roomPool.peek()[0]);
                while (!roomPool.isEmpty() && roomPool.peek()[0] <= clock) {
                    availableRooms.add((int) roomPool.poll()[1]);
                }
            }
            int room = availableRooms.remove();
            roomCount[room]++;
            roomPool.add(new long[] {clock + meeting[1] - meeting[0], room});
        }
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (roomCount[i] > roomCount[idx]) {
                idx = i;
            }
        }
        return idx;
    }
}
