package Problem1900;

public class Problem1974 {
    public int minTimeToType(String word) {
        int time = 0;
        char prev = 'a';
        for (char c : word.toCharArray()) {
            time += Math.min(Math.abs(c - prev), 26 - Math.abs(c - prev)) + 1;
            prev = c;
        }
        return time;
    }
}
