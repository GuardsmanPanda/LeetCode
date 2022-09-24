package Problem1300;

public class Problem1347 {
    public int minSteps(String s, String t) {
        int[] count = new int[128];
        s.chars().forEach(c -> count[c]++);
        return (int)t.chars().filter(c -> --count[c] < 0).count();
    }
}
