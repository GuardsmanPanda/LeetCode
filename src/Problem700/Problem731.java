package Problem700;

import java.util.ArrayList;
import java.util.List;

public class Problem731 {
    class MyCalendarTwo {
        private final List<int[]> calendar;
        private final List<int[]> overlaps;

        public MyCalendarTwo() {
            calendar = new ArrayList<>();
            overlaps = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] overlap : overlaps) {
                if (overlap[0] < end && start < overlap[1]) {
                    return false;
                }
            }
            for (int[] event : calendar) {
                if (event[0] < end && start < event[1]) {
                    overlaps.add(new int[]{Math.max(start, event[0]), Math.min(end, event[1])});
                }
            }
            calendar.add(new int[]{start, end});
            return true;
        }
    }
}
