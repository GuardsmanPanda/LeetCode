package Problem1600;

public class Problem1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char result = keysPressed.charAt(0);
        int max = releaseTimes[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > max || (time == max && keysPressed.charAt(i) > result)) {
                result = keysPressed.charAt(i);
                max = time;
            }
        }
        return result;
    }
}
