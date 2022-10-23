package Problem2400;

public class Problem2446 {
    public boolean haveConflict(String[] event1, String[] event2) {
        int maxStart = Math.max(timeToMinutes(event1[0]), timeToMinutes(event2[0]));
        int minEnd = Math.min(timeToMinutes(event1[1]), timeToMinutes(event2[1]));
        return maxStart <= minEnd;
    }

    private static int timeToMinutes(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}
